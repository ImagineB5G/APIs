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
/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.cm629.api;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.openslice.tmf.cm629.model.CustomerAttributeValueChangeEvent;
import io.openslice.tmf.cm629.model.CustomerCreateEvent;
import io.openslice.tmf.cm629.model.CustomerDeleteEvent;
import io.openslice.tmf.cm629.model.CustomerStateChangeEvent;
import io.openslice.tmf.cm629.model.EventSubscription;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

@Tag(name = "listener", description = "the listener API")
public interface ListenerApi {

    Logger log = LoggerFactory.getLogger(ListenerApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Client listener for entity CustomerAttributeValueChangeEvent", operationId = "listenToCustomerAttributeValueChangeEvent", description = "Example of a client listener for receiving the notification CustomerAttributeValueChangeEvent", tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Notified" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/listener/customerAttributeValueChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCustomerAttributeValueChangeEvent(@Parameter(description = "The event data" ,required=true )  @Valid @RequestBody CustomerAttributeValueChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Client listener for entity CustomerCreateEvent", operationId = "listenToCustomerCreateEvent", description = "Example of a client listener for receiving the notification CustomerCreateEvent", tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Notified" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/listener/customerCreateEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCustomerCreateEvent(@Parameter(description = "The event data" ,required=true )  @Valid @RequestBody CustomerCreateEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Client listener for entity CustomerDeleteEvent", operationId = "listenToCustomerDeleteEvent", description = "Example of a client listener for receiving the notification CustomerDeleteEvent", tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Notified" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/listener/customerDeleteEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCustomerDeleteEvent(@Parameter(description = "The event data" ,required=true )  @Valid @RequestBody CustomerDeleteEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Client listener for entity CustomerStateChangeEvent", operationId = "listenToCustomerStateChangeEvent", description = "Example of a client listener for receiving the notification CustomerStateChangeEvent", tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Notified" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/listener/customerStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCustomerStateChangeEvent(@Parameter(description = "The event data" ,required=true )  @Valid @RequestBody CustomerStateChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
