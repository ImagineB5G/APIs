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
/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.sqm657.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.sqm657.model.ServiceLevelObjective;
import io.openslice.tmf.sqm657.model.ServiceLevelObjectiveCreate;
import io.openslice.tmf.sqm657.model.ServiceLevelObjectiveUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

@Tag(name = "serviceLevelObjective", description = "the serviceLevelObjective API")
public interface ServiceLevelObjectiveApi {

    Logger log = LoggerFactory.getLogger(ServiceLevelObjectiveApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Creates a 'ServiceLevelObjective'", operationId = "createServiceLevelObjective", description = "", tags={ "serviceLevelObjective", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Created" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/serviceLevelObjective",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ServiceLevelObjective> createServiceLevelObjective(@Parameter(description = "The Service Level Objective to be created" ,required=true )  @Valid @RequestBody ServiceLevelObjectiveCreate serviceLevelObjective) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"specConsequence\" : [ {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  }, {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  } ],  \"conformanceComparator\" : \"conformanceComparator\",  \"graceTimes\" : \"graceTimes\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"specParameter\" : {    \"serviceParmCategory\" : \"serviceParmCategory\",    \"transformationAlgorithmOfKQI\" : \"transformationAlgorithmOfKQI\",    \"serviceParmPerspective\" : \"serviceParmPerspective\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"relatedEntity\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"name\" : \"name\",    \"type\" : \"type\",    \"@schemaLocation\" : \"@schemaLocation\"  },  \"conformanceTarget\" : \"conformanceTarget\",  \"toleranceTarget\" : \"toleranceTarget\",  \"@baseType\" : \"@baseType\",  \"tolerancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"name\" : \"name\",  \"conformancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"thresholdTarget\" : \"thresholdTarget\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}", ServiceLevelObjective.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ServiceLevelObjectiveApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Deletes a 'ServiceLevelObjective' by Id", operationId = "deleteServiceLevelObjective", description = "", tags={ "serviceLevelObjective", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Deleted" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/serviceLevelObjective/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteServiceLevelObjective(@Parameter(description = "Identifier of the Service Level Objective",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ServiceLevelObjectiveApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "List or find 'ServiceLevelObjective' objects", operationId = "listServiceLevelObjective", description = "" , tags={ "serviceLevelObjective", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode ="200", description = "Ok" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/serviceLevelObjective",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<ServiceLevelObjective>> listServiceLevelObjective(@Parameter(description = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"specConsequence\" : [ {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  }, {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  } ],  \"conformanceComparator\" : \"conformanceComparator\",  \"graceTimes\" : \"graceTimes\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"specParameter\" : {    \"serviceParmCategory\" : \"serviceParmCategory\",    \"transformationAlgorithmOfKQI\" : \"transformationAlgorithmOfKQI\",    \"serviceParmPerspective\" : \"serviceParmPerspective\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"relatedEntity\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"name\" : \"name\",    \"type\" : \"type\",    \"@schemaLocation\" : \"@schemaLocation\"  },  \"conformanceTarget\" : \"conformanceTarget\",  \"toleranceTarget\" : \"toleranceTarget\",  \"@baseType\" : \"@baseType\",  \"tolerancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"name\" : \"name\",  \"conformancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"thresholdTarget\" : \"thresholdTarget\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}, {  \"specConsequence\" : [ {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  }, {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  } ],  \"conformanceComparator\" : \"conformanceComparator\",  \"graceTimes\" : \"graceTimes\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"specParameter\" : {    \"serviceParmCategory\" : \"serviceParmCategory\",    \"transformationAlgorithmOfKQI\" : \"transformationAlgorithmOfKQI\",    \"serviceParmPerspective\" : \"serviceParmPerspective\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"relatedEntity\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"name\" : \"name\",    \"type\" : \"type\",    \"@schemaLocation\" : \"@schemaLocation\"  },  \"conformanceTarget\" : \"conformanceTarget\",  \"toleranceTarget\" : \"toleranceTarget\",  \"@baseType\" : \"@baseType\",  \"tolerancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"name\" : \"name\",  \"conformancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"thresholdTarget\" : \"thresholdTarget\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ServiceLevelObjectiveApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Updates partially a 'ServiceLevelObjective' by Id", operationId = "patchServiceLevelObjective", description = "", tags={ "serviceLevelObjective", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode ="200", description = "Updated" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/serviceLevelObjective/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<ServiceLevelObjective> patchServiceLevelObjective(@Parameter(description = "Identifier of the Service Level Objective",required=true) @PathVariable("id") String id,@Parameter(description = "The Service Level Objective to be updated" ,required=true )  @Valid @RequestBody ServiceLevelObjectiveUpdate serviceLevelObjective) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"specConsequence\" : [ {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  }, {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  } ],  \"conformanceComparator\" : \"conformanceComparator\",  \"graceTimes\" : \"graceTimes\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"specParameter\" : {    \"serviceParmCategory\" : \"serviceParmCategory\",    \"transformationAlgorithmOfKQI\" : \"transformationAlgorithmOfKQI\",    \"serviceParmPerspective\" : \"serviceParmPerspective\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"relatedEntity\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"name\" : \"name\",    \"type\" : \"type\",    \"@schemaLocation\" : \"@schemaLocation\"  },  \"conformanceTarget\" : \"conformanceTarget\",  \"toleranceTarget\" : \"toleranceTarget\",  \"@baseType\" : \"@baseType\",  \"tolerancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"name\" : \"name\",  \"conformancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"thresholdTarget\" : \"thresholdTarget\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}", ServiceLevelObjective.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ServiceLevelObjectiveApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Retrieves a 'ServiceLevelObjective' by Id", operationId = "retrieveServiceLevelObjective", description = "" , tags={ "serviceLevelObjective", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode ="200", description = "Ok" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/serviceLevelObjective/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<ServiceLevelObjective>> retrieveServiceLevelObjective(@Parameter(description = "Identifier of the Service Level Objective",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"specConsequence\" : [ {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  }, {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  } ],  \"conformanceComparator\" : \"conformanceComparator\",  \"graceTimes\" : \"graceTimes\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"specParameter\" : {    \"serviceParmCategory\" : \"serviceParmCategory\",    \"transformationAlgorithmOfKQI\" : \"transformationAlgorithmOfKQI\",    \"serviceParmPerspective\" : \"serviceParmPerspective\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"relatedEntity\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"name\" : \"name\",    \"type\" : \"type\",    \"@schemaLocation\" : \"@schemaLocation\"  },  \"conformanceTarget\" : \"conformanceTarget\",  \"toleranceTarget\" : \"toleranceTarget\",  \"@baseType\" : \"@baseType\",  \"tolerancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"name\" : \"name\",  \"conformancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"thresholdTarget\" : \"thresholdTarget\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}, {  \"specConsequence\" : [ {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  }, {    \"prescribedAction\" : \"prescribedAction\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"@schemaLocation\" : \"@schemaLocation\"  } ],  \"conformanceComparator\" : \"conformanceComparator\",  \"graceTimes\" : \"graceTimes\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"specParameter\" : {    \"serviceParmCategory\" : \"serviceParmCategory\",    \"transformationAlgorithmOfKQI\" : \"transformationAlgorithmOfKQI\",    \"serviceParmPerspective\" : \"serviceParmPerspective\",    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"relatedEntity\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"name\" : \"name\",    \"type\" : \"type\",    \"@schemaLocation\" : \"@schemaLocation\"  },  \"conformanceTarget\" : \"conformanceTarget\",  \"toleranceTarget\" : \"toleranceTarget\",  \"@baseType\" : \"@baseType\",  \"tolerancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"name\" : \"name\",  \"conformancePeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"thresholdTarget\" : \"thresholdTarget\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ServiceLevelObjectiveApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
