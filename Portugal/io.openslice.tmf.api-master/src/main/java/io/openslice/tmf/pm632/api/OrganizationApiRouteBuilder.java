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
package io.openslice.tmf.pm632.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.LoggingLevel;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.pm632.model.Organization;
import io.openslice.tmf.pm632.reposervices.OrganizationRepoService;

@Configuration
@Component
public class OrganizationApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(OrganizationApiRouteBuilder.class.getName());

	@Value("${EVENT_ORGANIZATION_CREATE}")
	private String EVENT_ORGANIZATION_CREATE = "";

	@Value("${EVENT_ORGANIZATION_CHANGED}")
	private String EVENT_ORGANIZATION_CHANGED = "";

	@Value("${CATALOG_GET_EXTERNAL_SERVICE_PARTNERS}")
	private String CATALOG_GET_EXTERNAL_SERVICE_PARTNERS = "";
	

	@Value("${CATALOG_GET_PARTNER_ORGANIZATON_BY_ID}")
	private String CATALOG_GET_PARTNER_ORGANIZATON_BY_ID = "";
	

	@Value("${CATALOG_UPDATE_PARTNER_ORGANIZATION}")
	private String CATALOG_UPDATE_PARTNER_ORGANIZATION = "";
	
	@Autowired
	private ProducerTemplate template;

    @Autowired
	OrganizationRepoService organizationRepoService;

	@Value("${spring.application.name}")
	private String compname;

	@Autowired
	private CentralLogger centralLogger;
	
	@Override
	public void configure() throws Exception {

		from( CATALOG_GET_EXTERNAL_SERVICE_PARTNERS )
		.log(LoggingLevel.INFO, log, CATALOG_GET_EXTERNAL_SERVICE_PARTNERS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( organizationRepoService, "getPartnerOrganizationsWithAPI")
		//.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_PARTNER_ORGANIZATON_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_PARTNER_ORGANIZATON_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( organizationRepoService, "findByUuidJson");
		

		from( CATALOG_UPDATE_PARTNER_ORGANIZATION )
		.log(LoggingLevel.INFO, log, CATALOG_UPDATE_PARTNER_ORGANIZATION + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal()
		.json(JsonLibrary.Jackson, Organization.class, true)		
		.bean( organizationRepoService, "updateOrganization( ${header.orgid}, ${body})")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
	}

	
	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}

}
