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

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.scm633.model.ImportJob;
import io.openslice.tmf.scm633.model.ImportJobCreate;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller("ImportJobApiController633")
@RequestMapping("/serviceCatalogManagement/v4/")
public class ImportJobApiController implements ImportJobApi {

    private static final Logger log = LoggerFactory.getLogger(ImportJobApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ImportJobApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ImportJob> createImportJob(@Parameter(description = "The ImportJob to be created" ,required=true )  @Valid @RequestBody ImportJobCreate importJob) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ImportJob>(objectMapper.readValue("{  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"@type\" : \"@type\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"errorLog\" : \"errorLog\",  \"id\" : \"id\",  \"href\" : \"href\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"url\" : \"url\",  \"status\" : \"status\"}", ImportJob.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ImportJob>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ImportJob>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteImportJob(@Parameter(description = "Identifier of the ImportJob",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ImportJob>> listImportJob(@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ImportJob>>(objectMapper.readValue("[ {  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"@type\" : \"@type\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"errorLog\" : \"errorLog\",  \"id\" : \"id\",  \"href\" : \"href\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"url\" : \"url\",  \"status\" : \"status\"}, {  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"@type\" : \"@type\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"errorLog\" : \"errorLog\",  \"id\" : \"id\",  \"href\" : \"href\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"url\" : \"url\",  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ImportJob>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ImportJob>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ImportJob> retrieveImportJob(@Parameter(description = "Identifier of the ImportJob",required=true) @PathVariable("id") String id,@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ImportJob>(objectMapper.readValue("{  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"@type\" : \"@type\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"errorLog\" : \"errorLog\",  \"id\" : \"id\",  \"href\" : \"href\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"url\" : \"url\",  \"status\" : \"status\"}", ImportJob.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ImportJob>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ImportJob>(HttpStatus.NOT_IMPLEMENTED);
    }

}
