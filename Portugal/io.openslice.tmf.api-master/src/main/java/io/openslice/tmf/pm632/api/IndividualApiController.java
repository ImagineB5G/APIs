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
package io.openslice.tmf.pm632.api;

import java.security.Principal;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.model.UserRoleType;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.Individual;
import io.openslice.tmf.pm632.model.IndividualCreate;
import io.openslice.tmf.pm632.model.IndividualUpdate;
import io.openslice.tmf.pm632.model.MediumCharacteristic;
import io.openslice.tmf.pm632.reposervices.IndividualRepoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Controller
@RequestMapping("/party/v4/")
public class IndividualApiController implements IndividualApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IndividualApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

	@Autowired
	IndividualRepoService individualRepoService;


	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<List<Individual>> listIndividual(@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
	
		
		

		try {



				return new ResponseEntity<List<Individual>>(individualRepoService.findAll(), HttpStatus.OK);				
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Individual>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	

//	 @PreAuthorize("hasAnyAuthority('USER" })
	 @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
	  public ResponseEntity<Individual> retrieveIndividual(
				Principal principal,			
				@Parameter(description = "Identifier of the Individual",required=true) @PathVariable("id") String id,
				@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {


		
			try {

				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				
				if ( id.equals( "myuser" ) ) {
					
					log.debug("principal=  " + principal.toString());
					
					Individual ind = individualRepoService.findByUsername(  principal.getName() );
					
					
					if ( ind != null ) {
						log.debug("principal.name {} ", principal.getName());
						return new ResponseEntity< Individual >( ind , HttpStatus.OK);		
					} else 
					{
						@Valid
						IndividualCreate individualnew  = new IndividualCreate();
						individualnew.setPreferredGivenName(  principal.getName() );
						individualnew.setFamilyName("N/A");
						individualnew.setGivenName("N/A");
						ContactMedium contactMediumItem = new ContactMedium();
						contactMediumItem.setPreferred(true);
						contactMediumItem.setMediumType("main");
						MediumCharacteristic mc = new MediumCharacteristic();
						contactMediumItem.setCharacteristic(mc );
						individualnew.addContactMediumItem(contactMediumItem );
						mc.setEmailAddress( "na@example.com" );		
						
						if ( principal instanceof JwtAuthenticationToken) {
							JwtAuthenticationToken pr = ( JwtAuthenticationToken ) principal;
							
							
							Jwt lp = (Jwt) pr.getPrincipal();
							individualnew.setPreferredGivenName(  lp.getClaimAsString("preferred_username") );							
							individualnew.setFamilyName( lp.getClaimAsString("name") );
							individualnew.setGivenName( lp.getClaimAsString("given_name")  );
							
							mc.setEmailAddress( lp.getClaimAsString("email") );							
							
							
						}
						return new ResponseEntity< Individual > ( individualRepoService.addIndividual(individualnew)   , HttpStatus.OK);
					}
									
					
					
				} else if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {

					return new ResponseEntity< Individual >(individualRepoService.findById(id) , HttpStatus.OK);				
				}else {
					return new ResponseEntity< Individual >(HttpStatus.FORBIDDEN );
				}
				

			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity< Individual >(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
    

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<Individual> createIndividual(
			@Parameter(description = "The Individual to be created", required = true) @Valid @RequestBody IndividualCreate individual) {

		try {
			Individual c = individualRepoService.addIndividual(individual);

			return new ResponseEntity<Individual>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN' , 'ROLE_USER')" )
	public ResponseEntity<Individual> patchIndividual(@Parameter(description = "Identifier of the Individual",required=true) @PathVariable("id") String id,@Parameter(description = "The Individual to be updated" ,required=true )  @Valid @RequestBody IndividualUpdate individual) {

		try {
			Individual c = individualRepoService.updateIndividual(id, individual);

			return new ResponseEntity<Individual>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	public ResponseEntity<Void> deleteIndividual(@Parameter(description = "Identifier of the Individual",required=true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>( individualRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
