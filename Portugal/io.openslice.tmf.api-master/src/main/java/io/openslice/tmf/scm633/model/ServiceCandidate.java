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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;

/**
 * ServiceCandidate is an entity that makes a service specification available to
 * a catalog. A ServiceCandidate and its associated service specification may be
 * published - made visible - in any number of service catalogs, or in none. One
 * service specification can be composed of other service specifications.
 */
@Schema(description = "ServiceCandidate is an entity that makes a service specification available to a catalog. A ServiceCandidate and its associated service specification may be published - made visible - in any number of service catalogs, or in none. One service specification can be composed of other service specifications.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Entity(name = "ServiceCandidate" )
@Table( name = "ServiceCandidate" )

public class ServiceCandidate extends BaseEntity {

	
	@ManyToMany( mappedBy ="serviceCandidateObj", cascade = {CascadeType.MERGE,  CascadeType.DETACH} )
	@JsonIgnore
	private Set<ServiceCategory> categoryObj = new HashSet<>();

	@OneToOne( cascade = {CascadeType.MERGE, CascadeType.DETACH} )
    @JoinColumn(name = "service_specid", referencedColumnName = "uuid")
	@JsonIgnore
	private ServiceSpecification serviceSpecificationObj = null;

	@JsonProperty("id")
	protected String id = null;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		if ( uuid != null ) {
			return uuid;			
		} else {
			return id;
		}
	}
	
	
	public ServiceCandidate() {
		super();
		this.type = "ServiceCandidate";
		this.baseType = "BaseEntity";
	}
	
	
	

	public String getVersion() {
		if ( this.serviceSpecificationObj != null )
		{
			return this.serviceSpecificationObj.getVersion();
		}
		
		return null;
	}

	public String getName() {
		if ( this.serviceSpecificationObj != null )
		{
			return this.serviceSpecificationObj.getName();
		}
		
		return null;
	}
	
	/**
	 * The service specification implied by this candidate
	 * 
	 * @return serviceSpecification
	 **/
	@Schema(description = "The service specification implied by this candidate")

	@Transient
	@JsonProperty("serviceSpecification")
	@Valid
	public ServiceSpecificationRef getServiceSpecificationRef() {
		if ( this.serviceSpecificationObj != null )
		{
			ServiceSpecificationRef sref = new ServiceSpecificationRef();
			
			sref.setId(  this.serviceSpecificationObj.getUuid());
			sref.setName(  this.serviceSpecificationObj.getName() );
			sref.setVersion( this.serviceSpecificationObj.getVersion());
			sref.setBaseType(ServiceSpecificationRef.class.getName());
			return sref;			
		}
		
		return null;
	}

	
	/**
	 * @return the serviceSpecificationObj
	 */
	public ServiceSpecification getServiceSpecificationObj() {
		return serviceSpecificationObj;
	}




	/**
	 * @param serviceSpecificationObj the serviceSpecificationObj to set
	 */

	@JsonProperty("serviceSpecification")
	public void setServiceSpecificationObj(ServiceSpecification serviceSpecificationObj) {
		this.serviceSpecificationObj = serviceSpecificationObj;
	}




	/**
	 * The service specification implied by this candidate
	 * 
	 * @return serviceSpecification
	 **/
	@Schema(description = "The category specification implied by this candidate")

	@Transient
	@JsonProperty("category")
	@Valid
	public List<ServiceCategoryRef> getCategory() {

		List<ServiceCategoryRef> category = new ArrayList<>();

		for (ServiceCategory serviceCategory : categoryObj) {
			ServiceCategoryRef scr = new ServiceCategoryRef();
			scr.setId(serviceCategory.getId());
			scr.setName(serviceCategory.getName());
			scr.setBaseType(ServiceCategoryRef.class.getName());
			category.add(scr);
		}

		return category;
	}



	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCandidate serviceCandidate = (ServiceCandidate) o;
		return Objects.equals(this.id, serviceCandidate.id) && Objects.equals(this.href, serviceCandidate.href)
				&& Objects.equals(this.description, serviceCandidate.description)
				&& Objects.equals(this.lastUpdate, serviceCandidate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCandidate.lifecycleStatus)
				&& Objects.equals(this.name, serviceCandidate.name)
				&& Objects.equals(this.version, serviceCandidate.version)
				&& Objects.equals(this.getCategory(), serviceCandidate.getCategory())
				&& Objects.equals(this.getServiceSpecificationRef() , serviceCandidate.getServiceSpecificationRef() )
				&& Objects.equals(this.validFor, serviceCandidate.validFor)
				&& Objects.equals(this.baseType, serviceCandidate.baseType)
				&& Objects.equals(this.schemaLocation, serviceCandidate.schemaLocation)
				&& Objects.equals(this.type, serviceCandidate.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, description, lastUpdate, lifecycleStatus, name, version, getCategory(),
//				getServiceSpecificationRef() , validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCandidate {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    category: ").append(toIndentedString(getCategory())).append("\n");
		sb.append("    serviceSpecification: ").append(toIndentedString(getServiceSpecificationRef() )).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

	/**
	 * @return the categoryObj
	 */
	public Set<ServiceCategory> getCategoryObj() {
		return categoryObj;
	}

	/**
	 * @param categoryObj the categoryObj to set
	 */
	public void setCategoryObj(Set<ServiceCategory> categoryObj) {
		this.categoryObj = categoryObj;
	}
}
