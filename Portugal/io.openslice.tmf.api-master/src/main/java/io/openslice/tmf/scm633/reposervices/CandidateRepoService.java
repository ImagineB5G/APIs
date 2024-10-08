/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.scm633.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.scm633.model.ServiceCandidate;
import io.openslice.tmf.scm633.model.ServiceCandidateCreate;
import io.openslice.tmf.scm633.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.repo.CandidateRepository;
import io.openslice.tmf.scm633.repo.ServiceSpecificationRepository;
import jakarta.validation.Valid;

@Service
public class CandidateRepoService {


	@Autowired
	CandidateRepository candidateRepo;	

	@Autowired
	CategoryRepoService categsRepoService;
	

	@Autowired
	ServiceSpecificationRepository serviceSpecificationRepo;
	
	public ServiceCandidate addServiceCandidate( ServiceCandidate c) {

		return this.candidateRepo.save( c );
	}
	
	//@Transactional(propagation=Propagation.REQUIRED, readOnly=false, noRollbackFor=Exception.class)
	public ServiceCandidate addServiceCandidate(@Valid ServiceCandidateCreate serviceCand) {	
		

		ServiceCandidate sc = new ServiceCandidate() ;
//		if ( serviceCand.getServiceSpecification() != null) {
//			Optional<ServiceCandidate> optsc = this.candidateRepo.findByServiceSpecUuid(serviceCand.getServiceSpecification().getId());
//			if (optsc.isPresent() ) {
//					sc = optsc.get();//add to an existing candidate
//			}
//		}
		
		sc = updateServiceCandidateDataFromAPI( sc, serviceCand);
		
		return this.candidateRepo.save( sc );
	}

	public List<ServiceCandidate> findAll() {
		return (List<ServiceCandidate>) this.candidateRepo.findAll();
	}

	//@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public ServiceCandidate findById(String id) {
		Optional<ServiceCandidate> optionalCat = this.candidateRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceCandidate> optionalCat = this.candidateRepo.findByUuid( id );
		if ( !optionalCat.isEmpty() ) {
			this.candidateRepo.delete( optionalCat.get());			
		}
		return null;
		
	}

	@Transactional
	public ServiceCandidate updateCandidate(String id, @Valid ServiceCandidateUpdate serviceCandidate) {
		Optional<ServiceCandidate> scopt = this.candidateRepo.findByUuid(id);
		if ( scopt == null ) {
			return null;
		}
		ServiceCandidate sc = scopt.get();
		
		sc = updateServiceCandidateDataFromAPI( sc, serviceCandidate);
		
		return this.candidateRepo.save( sc );
	}
	

	@Transactional
	public ServiceCandidate updateServiceCandidateDataFromAPI(ServiceCandidate sc, @Valid ServiceCandidateUpdate serviceCandidateUpd) {	

		ServiceSpecification specObj =  null;
		
		if ( serviceCandidateUpd.getServiceSpecification()!=null) {
			Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findByUuid( serviceCandidateUpd.getServiceSpecification().getId() );
			specObj =  optionalCat.orElse(null);
		}
		
		if ( specObj != null ) {
			sc.setName( specObj.getName() );
			sc.setDescription( specObj.getDescription() );
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( specObj.getLifecycleStatus() ) );
			sc.setVersion( specObj.getVersion() );
		} else {
			sc.setName( serviceCandidateUpd.getName() );
			sc.setDescription( serviceCandidateUpd.getDescription() );	
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
			sc.setVersion( serviceCandidateUpd.getVersion());
		}
		
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		if ( serviceCandidateUpd.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCandidateUpd.getLifecycleStatus() ) );
		}
		TimePeriod tp = new TimePeriod();

		if ( sc.getValidFor() != null ){
			tp.setStartDateTime( sc.getValidFor().getStartDateTime() );
			tp.setEndDateTime( sc.getValidFor().getEndDateTime() );
		}
		sc.setValidFor( tp );
		
		if ( specObj != null){
			sc.setServiceSpecificationObj( specObj );			
		}
		
		//save first to continue
		ServiceCandidate savedCand = this.candidateRepo.save( sc );
		
		if ( serviceCandidateUpd.getCategory() !=null ){
			for (ServiceCategoryRef sCategD : serviceCandidateUpd.getCategory()) {			
				ServiceCategory catObj = this.categsRepoService.findByIdEager(sCategD.getId());

				if ( catObj!=null){
					catObj.getServiceCandidateObj().add(savedCand); //add candidate ref to category
					catObj = this.categsRepoService.categsRepo.save(catObj); 
					
				}
			}			
		}
		
		
		return savedCand;
	}
	
	
}
