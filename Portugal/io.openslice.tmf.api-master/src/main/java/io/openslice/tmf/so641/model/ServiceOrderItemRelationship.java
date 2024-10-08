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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Linked service order item to the one containing this attribute
 */
@Schema(description = "Linked service order item to the one containing this attribute")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "ServiceOrderItemRelationship")
public class ServiceOrderItemRelationship  extends BaseRootEntity {
	
	
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  public ServiceOrderItemRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a service order item
   * @return id
  **/
  @Schema(description = "Unique identifier of a service order item")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceOrderItemRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * The type of related order item, can be: dependency if the order item needs to be not started until another order item is complete
   * @return relationshipType
  **/
  @Schema(description = "The type of related order item, can be: dependency if the order item needs to be not started until another order item is complete")
  @NotNull


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceOrderItemRelationship serviceOrderItemRelationship = (ServiceOrderItemRelationship) o;
    return Objects.equals(this.id, serviceOrderItemRelationship.id) &&
        Objects.equals(this.relationshipType, serviceOrderItemRelationship.relationshipType) &&
        Objects.equals(this.baseType, serviceOrderItemRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceOrderItemRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceOrderItemRelationship.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, relationshipType, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderItemRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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

