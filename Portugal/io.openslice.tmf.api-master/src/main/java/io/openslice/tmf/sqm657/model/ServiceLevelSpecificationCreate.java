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
package io.openslice.tmf.sqm657.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications. Skipped properties: id,href
 */
@Schema(description = "A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelSpecificationCreate   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("objective")
  @Valid
  private List<ServiceLevelObjectiveRef> objective = new ArrayList<>();

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public ServiceLevelSpecificationCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A brief introduction of a service level specification.
   * @return description
  **/
  @Schema(description = "A brief introduction of a service level specification.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceLevelSpecificationCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of Service Level Specification
   * @return name
  **/
  @Schema(description = "The name of Service Level Specification")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceLevelSpecificationCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * A valid duration of a thing.
   * @return validFor
  **/
  @Schema(description = "A valid duration of a thing.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceLevelSpecificationCreate objective(List<ServiceLevelObjectiveRef> objective) {
    this.objective = objective;
    return this;
  }

  public ServiceLevelSpecificationCreate addObjectiveItem(ServiceLevelObjectiveRef objectiveItem) {
    this.objective.add(objectiveItem);
    return this;
  }

  /**
   * Get objective
   * @return objective
  **/
  @Schema(description = "")
  @NotNull

  @Valid

  public List<ServiceLevelObjectiveRef> getObjective() {
    return objective;
  }

  public void setObjective(List<ServiceLevelObjectiveRef> objective) {
    this.objective = objective;
  }

  public ServiceLevelSpecificationCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @Schema(description = "The class type of the actual resource (for type extension).")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ServiceLevelSpecificationCreate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A link to the schema describing a resource (for type extension).
   * @return schemaLocation
  **/
  @Schema(description = "A link to the schema describing a resource (for type extension).")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ServiceLevelSpecificationCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The base type for use in polymorphic collections
   * @return baseType
  **/
  @Schema(description = "The base type for use in polymorphic collections")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceLevelSpecificationCreate serviceLevelSpecificationCreate = (ServiceLevelSpecificationCreate) o;
    return Objects.equals(this.description, serviceLevelSpecificationCreate.description) &&
        Objects.equals(this.name, serviceLevelSpecificationCreate.name) &&
        Objects.equals(this.validFor, serviceLevelSpecificationCreate.validFor) &&
        Objects.equals(this.objective, serviceLevelSpecificationCreate.objective) &&
        Objects.equals(this.type, serviceLevelSpecificationCreate.type) &&
        Objects.equals(this.schemaLocation, serviceLevelSpecificationCreate.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelSpecificationCreate.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, validFor, objective, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelSpecificationCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    objective: ").append(toIndentedString(objective)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
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

