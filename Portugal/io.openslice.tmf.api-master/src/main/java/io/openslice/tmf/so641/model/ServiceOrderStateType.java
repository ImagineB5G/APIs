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
package io.openslice.tmf.so641.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Possible values for the state of the order
 */
public enum ServiceOrderStateType {
	
	INITIAL("INITIAL"),

	ACKNOWLEDGED("ACKNOWLEDGED"),

	REJECTED("REJECTED"),

	PENDING("PENDING"),

	HELD("HELD"),

	INPROGRESS("INPROGRESS"),

	CANCELLED("CANCELLED"),

	COMPLETED("COMPLETED"),

	FAILED("FAILED"),

	PARTIAL("PARTIAL");

	private String value;

	ServiceOrderStateType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static ServiceOrderStateType fromValue(String text) {
		for (ServiceOrderStateType b : ServiceOrderStateType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
