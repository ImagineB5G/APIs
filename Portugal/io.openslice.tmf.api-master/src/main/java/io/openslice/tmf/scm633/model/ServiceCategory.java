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
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories.
 */
@Schema(description = "The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceCategory")
@Table( name = "ServiceCategory" )
public class ServiceCategory extends BaseEntity {


	@JsonProperty("isRoot")
	private Boolean isRoot = null;


	@JsonProperty("parentId")
	private String parentId = null;


	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable()	
	@JsonIgnore
	private Set<ServiceCategory> categoryObj = new HashSet<>();
	
	

	@ManyToMany(cascade = {  CascadeType.MERGE, CascadeType.REMOVE } )
	@JoinTable()	
	@JsonIgnore
	private Set<ServiceCandidate> serviceCandidateObj = new HashSet<>();
	
	@JsonProperty("id")
	protected String id = null;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}

//	@Transient
//	@JsonProperty("serviceCandidate")
//	@Valid
//	private List<ServiceCandidateRef> serviceCandidate = null;


	public ServiceCategory() {
		super();
		this.baseType = "BaseEntity";
		this.type = "ServiceCategory";
	}

	


	/**
	 * If true, this Boolean indicates that the category is a root of categories
	 * 
	 * @return isRoot
	 **/
	@Schema(description = "If true, this Boolean indicates that the category is a root of categories")

	public Boolean isIsRoot() {
		return isRoot;
	}

	public void setIsRoot(Boolean isRoot) {
		if ( isRoot == null ) {
			this.isRoot = true;
		} else {
			this.isRoot = isRoot;
		}
	}



	/**
	 * Unique identifier of the parent category
	 * 
	 * @return parentId
	 **/
	@Schema(description = "Unique identifier of the parent category")

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}





	/**
	 * List of child categories in the tree for in this category
	 * 
	 * @return category
	 **/
	@Schema(description = "List of child categories in the tree for in this category")
	@Transient
	@JsonProperty("category")
	@Valid
	public List<ServiceCategoryRef> getCategoryRefs() {

		List<ServiceCategoryRef> category = new ArrayList<>();
		
		for (ServiceCategory serviceCategory : categoryObj) {
			ServiceCategoryRef scr = new ServiceCategoryRef();
			scr.setId( serviceCategory.getId());
			scr.setName( serviceCategory.getName());
			scr.setBaseType( ServiceCategoryRef.class.getName() );
			category.add(scr);
			
		}
		
		return category;
	}
	
	
	/**
	 * @param categoryObj the categoryObj to set
	 */
	@JsonProperty("category")
	public void setCategoryObj(List<ServiceCategoryRef> alist) {
		this.categoryObj.clear();
		for (ServiceCategoryRef serviceCategoryRef : alist) {
			ServiceCategory sc = new ServiceCategory();
			sc.setUuid( serviceCategoryRef.getId());
			sc.setName(serviceCategoryRef.getName());
			sc.setBaseType(serviceCategoryRef.getBaseType());
			this.categoryObj.add(sc);
		}
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

	

	/**
	 * List of service candidates associated with this category
	 * 
	 * @return serviceCandidate
	 **/
	@Schema(description = "List of service candidates associated with this category")

	@Valid
	@JsonProperty("serviceCandidate")
	public List<ServiceCandidateRef> getServiceCandidateRefs() {
		
		List<ServiceCandidateRef> scref = new ArrayList<>();
		
		for (ServiceCandidate sc : serviceCandidateObj) {
			ServiceCandidateRef scr = new ServiceCandidateRef();
			scr.setId( sc.getId());
			scr.setName( sc.getName());
			scr.setVersion( sc.getVersion());
			scr.setBaseType( ServiceCategoryRef.class.getName() );
			scref.add(scr);
		}
		
		return scref;
	}

	

	/**
	 * @return the serviceCandidateObj
	 */
	public Set<ServiceCandidate> getServiceCandidateObj() {
		return serviceCandidateObj;
	}




	/**
	 * @param serviceCandidateObj the serviceCandidateObj to set
	 */
	@JsonProperty("serviceCandidate")
	public void setServiceCandidateObj(Set<ServiceCandidate> serviceCandidateObj) {
		this.serviceCandidateObj = serviceCandidateObj;
	}




	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCategory serviceCategory = (ServiceCategory) o;
		return Objects.equals(this.id, serviceCategory.id) && Objects.equals(this.href, serviceCategory.href)
				&& Objects.equals(this.description, serviceCategory.description)
				&& Objects.equals(this.isRoot, serviceCategory.isRoot)
				&& Objects.equals(this.lastUpdate, serviceCategory.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCategory.lifecycleStatus)
				&& Objects.equals(this.name, serviceCategory.name)
				&& Objects.equals(this.parentId, serviceCategory.parentId)
				&& Objects.equals(this.version, serviceCategory.version)
				&& Objects.equals(this.getCategoryRefs(), serviceCategory.getCategoryRefs())
				&& Objects.equals(this.getServiceCandidateRefs(), serviceCategory.getServiceCandidateRefs())
				&& Objects.equals(this.validFor, serviceCategory.validFor)
				&& Objects.equals(this.baseType, serviceCategory.baseType)
				&& Objects.equals(this.schemaLocation, serviceCategory.schemaLocation)
				&& Objects.equals(this.type, serviceCategory.type);
	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, description, isRoot, lastUpdate, lifecycleStatus, name, parentId, version,
////				getCategoryObj(), getServiceCandidateObj(), 
//				validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCategory {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    category: ").append(toIndentedString(getCategoryRefs())).append("\n");
		sb.append("    serviceCandidate: ").append(toIndentedString(getServiceCandidateRefs())).append("\n");
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
}
