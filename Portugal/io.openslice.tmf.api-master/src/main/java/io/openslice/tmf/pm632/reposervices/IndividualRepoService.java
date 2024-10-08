/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.pm632.reposervices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.pm632.api.IndividualApiRouteBuilder;
import io.openslice.tmf.pm632.model.Characteristic;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.Individual;
import io.openslice.tmf.pm632.model.IndividualAttributeValueChangeEvent;
import io.openslice.tmf.pm632.model.IndividualAttributeValueChangeEventPayload;
import io.openslice.tmf.pm632.model.IndividualCreate;
import io.openslice.tmf.pm632.model.IndividualCreateEvent;
import io.openslice.tmf.pm632.model.IndividualCreateEventPayload;
import io.openslice.tmf.pm632.model.IndividualUpdate;
import io.openslice.tmf.pm632.repo.IndividualRepository;
import jakarta.validation.Valid;


@Service
@Transactional
public class IndividualRepoService {

	@Autowired
	IndividualRepository individualRepository;

	@Autowired
	IndividualApiRouteBuilder individualApiRouteBuilder;
	
	public List<Individual> findAll() {
		return (List<Individual>) this.individualRepository.findByOrderByFamilyName();
	}

	public Individual addIndividual(@Valid IndividualCreate individual) {
		Individual c = new Individual();
		c = updateIndividualData(c, individual);
		c = individualRepository.save(c);
		raiseIndividualCreate( c );
		return c;
	}
	
	public Individual updateIndividual(String id, @Valid IndividualUpdate individual) {
		Individual c = this.findByUuid(id);
		if ( c == null) {
			return null;
		}
		c = this.updateIndividualData(c, individual);
		c = this.individualRepository.save(c);
		raiseIndividualChanged(c);
		return c;
	}

	private Individual findByUuid(String id) {
		Optional<Individual> optionalCat = this.individualRepository.findByUuid(id);
		return optionalCat.orElse(null);
	}

	private Individual updateIndividualData(Individual c, @Valid IndividualUpdate indvUpd) {
		
		if ( indvUpd.getFamilyName()!=null) {
			c.setFamilyName( indvUpd.getFamilyName() );
		}
		
		if ( indvUpd.getFullName() !=null) {
			c.setFullName( indvUpd.getFullName() );
		}
		
		if ( indvUpd.getGivenName() !=null) {
			c.setGivenName( indvUpd.getGivenName() );
		}

		
		if ( indvUpd.getPreferredGivenName() !=null) {
			c.setPreferredGivenName( indvUpd.getPreferredGivenName() );
		}
		
		if ( indvUpd.getLocation() !=null) {
			c.setLocation( indvUpd.getLocation() );
		}
		
		if ( indvUpd.getContactMedium() !=null) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ContactMedium cmUpd : indvUpd.getContactMedium()) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ContactMedium originalCm : c.getContactMedium()) {
					if ( ( originalCm.getUuid()!=null ) && originalCm.getUuid().equals(cmUpd.getUuid() ) ) {
						idexists = true;
						idAddedUpdated.put( originalCm.getUuid(), true);
						originalCm.updateWith( cmUpd );
						break;
					}
				}
				if (!idexists) {
					c.addContactMediumItem( cmUpd );
					idAddedUpdated.put( cmUpd.getUuid(),  true);
				}
			}
			List<ContactMedium> toRemove = new ArrayList<>();
			for (ContactMedium ss : c.getContactMedium() ) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (ContactMedium schar : toRemove) {
				c.getContactMedium().remove( schar );
			}
		}
		
		if ( indvUpd.getPartyCharacteristic() !=null) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (Characteristic cmUpd : indvUpd.getPartyCharacteristic()) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (Characteristic originalCm : c.getPartyCharacteristic()) {
					if (  originalCm.getName().equals(cmUpd.getName() ) )  {
						idexists = true;
						idAddedUpdated.put( originalCm.getName() , true);
						originalCm.updateWith( cmUpd );
						break;
					}
				}
				if (!idexists) {
					c.addPartyCharacteristicItem(  new Characteristic(cmUpd) );
					idAddedUpdated.put( cmUpd.getName(), true);
				}
				
			}
			
			List<Characteristic> toRemove = new ArrayList<>();
			for (Characteristic ss : c.getPartyCharacteristic()) {
				if (idAddedUpdated.get(ss.getName()) == null) {
					toRemove.add(ss);
				}
			}

			for (Characteristic schar : toRemove) {
				c.getPartyCharacteristic().remove( schar );
			}
			
		}
		
		return c;
	}

	public Individual findById(String id) {
		Optional<Individual> c = this.individualRepository.findByUuid(id);
		return c.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<Individual> c = this.individualRepository.findByUuid(id);
		this.individualRepository.delete( c.get());
		return null;
	}

	
	private void raiseIndividualCreate(Individual c) {
		
		IndividualCreateEvent ce = new IndividualCreateEvent();
		IndividualCreateEventPayload event = new IndividualCreateEventPayload();
		event.setIndividual(c);
		ce.setEvent(event);
		individualApiRouteBuilder.publishEvent( ce, c.getId() );		
	}
	
	
	private void raiseIndividualChanged(Individual c) {
		
		IndividualAttributeValueChangeEvent ce = new IndividualAttributeValueChangeEvent();
		IndividualAttributeValueChangeEventPayload event = new IndividualAttributeValueChangeEventPayload();
		event.setIndividual(c);
		ce.setEvent(event);
		individualApiRouteBuilder.publishEvent( ce, c.getId() );
		
	}

	/**
	 * @param username
	 * @return
	 */
	public Individual findByUsername(String username) {
		Optional<Individual> c = this.individualRepository.findByPreferredGivenName( username );
		return c.orElse( null );
		
		
//		Individual ind = new Individual();
//		ind.getPreferredGivenName()
//		return null;
	}

}
