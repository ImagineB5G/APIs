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
package io.openslice.tmf.pm632.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Describes a given characteristic of an object or entity through a name/value
 * pair.
 */
@Schema(description = "Describes a given characteristic of an object or entity through a name/value pair.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")
@Entity(name = "PM632_Characteristic")
public class Characteristic extends BaseRootNamedEntity {

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("value")
	private Any value = null;

	
	public Characteristic() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();		
	}
	
	public Characteristic(Characteristic src) {
		this();
		name = src.name;
		valueType = src.valueType;
		value = new Any( src.value ) ;
		
	}

	public Characteristic name(String name) {
		this.name = name;
		return this;
	}

	public Characteristic valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * Data type of the value of the characteristic
	 * 
	 * @return valueType
	 **/
	@Schema(description = "Data type of the value of the characteristic")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public Characteristic value(Any value) {
		this.value = value;
		return this;
	}

	/**
	 * The value of the characteristic
	 * 
	 * @return value
	 **/
	@Schema(description = "The value of the characteristic")
	@NotNull

	@Valid

	public Any getValue() {
		return value;
	}

	public void setValue(Any value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Characteristic characteristic = (Characteristic) o;
		return Objects.equals(this.name, characteristic.name)
				&& Objects.equals(this.valueType, characteristic.valueType)
				&& Objects.equals(this.value, characteristic.value)
				&& Objects.equals(this.baseType, characteristic.baseType)
				&& Objects.equals(this.schemaLocation, characteristic.schemaLocation)
				&& Objects.equals(this.type, characteristic.type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Characteristic {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public void updateWith(Characteristic cmUpd) {
			this.setName( cmUpd.getName());
			this.setValue(new Any( cmUpd.getValue().getValue(), cmUpd.getValue().getAlias()));
			this.setValueType(cmUpd.getValueType());
			
	}
}
