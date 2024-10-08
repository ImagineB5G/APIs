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
package io.openslice.tmf.scm633.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm633.reposervices.CatalogRepoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller
@RequestMapping("/serviceCatalogManagement/v4/")
public class ServiceCatalogApiController implements ServiceCatalogApi {

    private static final Logger log = LoggerFactory.getLogger(ServiceCatalogApiController.class);

    

	@Autowired
	CatalogRepoService catalogRepoService;


	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    public ResponseEntity<ServiceCatalog> createServiceCatalog(
    		@Parameter(description = "The ServiceCatalog to be created" ,required=true )  @Valid @RequestBody ServiceCatalogCreate serviceCatalog) {
    	try {

    		ServiceCatalog c = catalogRepoService.addCatalog( serviceCatalog );

			return new ResponseEntity<ServiceCatalog>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    public ResponseEntity<Void> deleteServiceCatalog(@Parameter(description = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id) {
    	try {

			return new ResponseEntity<Void>( catalogRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<List<ServiceCatalog>> listServiceCatalog(@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
       
        try {
			return new ResponseEntity<List<ServiceCatalog>>( catalogRepoService.findAll() , HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceCatalog>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    public ResponseEntity<ServiceCatalog> patchServiceCatalog(@Parameter(description = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id,@Parameter(description = "The ServiceCatalog to be updated" ,required=true )  @Valid @RequestBody ServiceCatalogUpdate serviceCatalog) {

		ServiceCatalog c = catalogRepoService.updateCatalog( id, serviceCatalog );

		return new ResponseEntity<ServiceCatalog>(c, HttpStatus.OK);
    }

    public ResponseEntity<ServiceCatalog> retrieveServiceCatalog(@Parameter(description = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id,@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	try {

			return new ResponseEntity<ServiceCatalog>( catalogRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
