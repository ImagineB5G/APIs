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
package io.openslice.tmf.cm629.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.cm629.model.CustomerAttributeValueChangeEvent;
import io.openslice.tmf.cm629.model.CustomerCreateEvent;

@Configuration
@Component
public class CustomerApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(CustomerApiRouteBuilder.class.getName());

	@Value("${EVENT_CUSTOMER_CREATE}")
	private String EVENT_CUSTOMER_CREATE = "";

	@Value("${EVENT_CUSTOMER_CHANGED}")
	private String EVENT_CUSTOMER_CHANGED = "";

	@Autowired
	private ProducerTemplate template;


	@Value("${spring.application.name}")
	private String compname;

	@Autowired
	private CentralLogger centralLogger;
	
	@Override
	public void configure() throws Exception {

	}

	/**
	 * @param ce
	 * @param id
	 */
	public void publishEvent(Object ce, String objId) {
		try {
			String msgtopic = "";

			Map<String, Object> map = new HashMap<>();
			map.put("objId", objId);

			if (ce instanceof CustomerCreateEvent) {
				msgtopic = EVENT_CUSTOMER_CREATE;
				((CustomerCreateEvent) ce).setEventType(ce.getClass().getName());
				map.put("eventid", ((CustomerCreateEvent) ce).getEventId());
				logger.info("will send Event for type " + ((CustomerCreateEvent) ce).getEventType());
			} else if (ce instanceof CustomerAttributeValueChangeEvent) {
				msgtopic = EVENT_CUSTOMER_CHANGED;

				((CustomerAttributeValueChangeEvent) ce).setEventType(ce.getClass().getName());
				map.put("eventid", ((CustomerAttributeValueChangeEvent) ce).getEventId());
				logger.info("will send Event for type " + ((CustomerAttributeValueChangeEvent) ce).getEventType());
			}

			String apayload = toJsonString( ce );
			template.sendBodyAndHeaders(msgtopic, apayload, map);

			centralLogger.log(CLevel.INFO, apayload, compname);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Cannot send Event . " + e.getMessage());
		}

	}
	
	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}

}
