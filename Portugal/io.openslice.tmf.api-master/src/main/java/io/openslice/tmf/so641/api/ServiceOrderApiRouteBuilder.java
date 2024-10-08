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
package io.openslice.tmf.so641.api;

import java.io.IOException;
import java.util.Map;

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
import io.openslice.model.PortalUser;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;

@Configuration
//@RefreshScope
@Component
public class ServiceOrderApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderApiRouteBuilder.class.getName());

	@Value("${CATALOG_GET_SERVICEORDER_BY_ID}")
	private String CATALOG_GET_SERVICEORDER_BY_ID = "";

	@Value("${CATALOG_GET_SERVICEORDERS}")
	private String CATALOG_GET_SERVICEORDERS = "";

	@Value("${CATALOG_GET_INITIAL_SERVICEORDERS_IDS}")
	private String CATALOG_GET_INITIAL_SERVICEORDERS_IDS = "";

	@Value("${CATALOG_GET_SERVICEORDER_IDS_BY_STATE}")
	private String CATALOG_GET_SERVICEORDER_IDS_BY_STATE = "";

	@Value("${CATALOG_UPD_SERVICEORDER_BY_ID}")
	private String CATALOG_UPD_SERVICEORDER_BY_ID = "";

	@Value("${CATALOG_ADD_SERVICEORDER}")
	private String CATALOG_ADD_SERVICEORDER = "";
	


	@Value("${GET_USER_BY_USERNAME}")
	private String GET_USER_BY_USERNAME = "";
	

	@Value("${spring.application.name}")
	private String compname;
	
	@Autowired
	private ProducerTemplate template;

	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;

	@Autowired
	private CentralLogger centralLogger;

	@Override
	public void configure() throws Exception {

		from(CATALOG_GET_SERVICEORDERS).log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDERS + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true")
				.bean(serviceOrderRepoService, "findAllParamsJsonOrderIDs").convertBodyTo(String.class);

//		final Map<String,String> propertiesMap = new HashMap<String,String>();
//        propertiesMap.put("state", "INITIAL"); 
//        logger.info( "propertiesMap.toString() = " + propertiesMap.toString() );

		from(CATALOG_GET_INITIAL_SERVICEORDERS_IDS)
				.log(LoggingLevel.INFO, log, CATALOG_GET_INITIAL_SERVICEORDERS_IDS + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").setBody(constant("{\"state\":\"INITIAL\"}")).unmarshal()
				.json(JsonLibrary.Jackson, Map.class, true).bean(serviceOrderRepoService, "findAllParamsJsonOrderIDs")
				.convertBodyTo(String.class);

		from(CATALOG_GET_SERVICEORDER_IDS_BY_STATE)
				.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDER_IDS_BY_STATE + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").setBody(simple("{\"state\":\"${header.orderstate}\"}"))
				.unmarshal().json(JsonLibrary.Jackson, Map.class, true)
				.bean(serviceOrderRepoService, "findAllParamsJsonOrderIDs").convertBodyTo(String.class);

		from(CATALOG_GET_SERVICEORDER_BY_ID)
				.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDER_BY_ID + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true")
				.bean(serviceOrderRepoService, "getServiceOrderEagerAsString").convertBodyTo(String.class);

		from(CATALOG_UPD_SERVICEORDER_BY_ID)
				.log(LoggingLevel.INFO, log, CATALOG_UPD_SERVICEORDER_BY_ID + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").unmarshal()
				.json(JsonLibrary.Jackson, ServiceOrderUpdate.class, true)
				.bean(serviceOrderRepoService, "updateServiceOrder(${header.orderid}, ${body})");
		

		from(CATALOG_ADD_SERVICEORDER)
				.log(LoggingLevel.INFO, log, CATALOG_ADD_SERVICEORDER + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").unmarshal()
				.json(JsonLibrary.Jackson, ServiceOrderCreate.class, true)
				.bean(serviceOrderRepoService, "addServiceOrderReturnEager(${body})")
				.convertBodyTo(String.class); //creates back a response
		

	}

	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}

	/**
	 * get  service order by id from model via bus
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public PortalUser retrievePortalUser( String userName ) {
		logger.info("will retrieve PortalUser from userName =" + userName   );
		try {
			Object response = template.
					requestBody( GET_USER_BY_USERNAME, userName);

			if ( !(response instanceof String)) {
				logger.error("PortalUser object is wrong.");
				return null;
			}
			PortalUser sor = toJsonObj( (String)response, PortalUser.class); 
			return sor;
			
		}catch (Exception e) {
			logger.error("Cannot retrieve PortalUser details from catalog. " + e.toString());
		}
		return null;
	}
	

	
	static <T> T toJsonObj(String content, Class<T> valueType)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue( content, valueType);
    }
	
	
}
