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
package io.openslice.tmf.scm633.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories.
 */
@Schema(description = "The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@JsonIgnoreProperties( {"uuid"} )
public class ServiceCategoryRef extends BaseRootNamedEntity {

	
	@JsonProperty("@referredType")
	private String referredType = null;

	public ServiceCategoryRef() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ServiceCategoryRef referredType(String referredType) {
		this.referredType = referredType;
		return this;
	}
	
	@JsonProperty("id")
	protected String id = null;
	
	
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return referredType
	 **/
	@Schema(description = "The actual type of the target instance when needed for disambiguation.")

	public String getReferredType() {
		return referredType;
	}

	public void setReferredType(String referredType) {
		this.referredType = referredType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCategoryRef serviceCategoryRef = (ServiceCategoryRef) o;
		return Objects.equals(this.id, serviceCategoryRef.id) && Objects.equals(this.href, serviceCategoryRef.href)
				&& Objects.equals(this.name, serviceCategoryRef.name)
				&& Objects.equals(this.baseType, serviceCategoryRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceCategoryRef.schemaLocation)
				&& Objects.equals(this.type, serviceCategoryRef.type)
				&& Objects.equals(this.referredType, serviceCategoryRef.referredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, name, baseType, schemaLocation, type, referredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCategoryRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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
}
