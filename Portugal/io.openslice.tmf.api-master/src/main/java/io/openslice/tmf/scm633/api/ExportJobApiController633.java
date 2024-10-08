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

import io.openslice.tmf.scm633.model.ExportJob;
import io.openslice.tmf.scm633.model.ExportJobCreate;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller("ExportJobApiController633")
@RequestMapping("/serviceCatalogManagement/v4/")
public class ExportJobApiController633 implements ExportJobApi {

    private static final Logger log = LoggerFactory.getLogger(ExportJobApiController633.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExportJobApiController633(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ExportJob> createExportJob(@Parameter(description = "The ExportJob to be created" ,required=true )  @Valid @RequestBody ExportJobCreate exportJob) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ExportJob>(objectMapper.readValue("{  \"@type\" : \"@type\",  \"query\" : \"query\",  \"errorLog\" : \"errorLog\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"url\" : \"url\",  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"status\" : \"status\"}", ExportJob.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ExportJob>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ExportJob>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteExportJob(@Parameter(description = "Identifier of the ExportJob",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ExportJob>> listExportJob(@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ExportJob>>(objectMapper.readValue("[ {  \"@type\" : \"@type\",  \"query\" : \"query\",  \"errorLog\" : \"errorLog\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"url\" : \"url\",  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"status\" : \"status\"}, {  \"@type\" : \"@type\",  \"query\" : \"query\",  \"errorLog\" : \"errorLog\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"url\" : \"url\",  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ExportJob>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ExportJob>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ExportJob> retrieveExportJob(@Parameter(description = "Identifier of the ExportJob",required=true) @PathVariable("id") String id,@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ExportJob>(objectMapper.readValue("{  \"@type\" : \"@type\",  \"query\" : \"query\",  \"errorLog\" : \"errorLog\",  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"url\" : \"url\",  \"path\" : \"path\",  \"@baseType\" : \"@baseType\",  \"completionDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"contentType\" : \"contentType\",  \"status\" : \"status\"}", ExportJob.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ExportJob>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ExportJob>(HttpStatus.NOT_IMPLEMENTED);
    }

}
