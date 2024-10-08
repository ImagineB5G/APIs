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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * The related entity source of a KQI or KPI. A KQI draws its data from a number of sources,  including Key Performance Indicators (KPIs).  A KPI provides a measurement of a specific aspect  of the performance of a Service (whether it is a network- or a non-network-based Service) or a  group of Services of the same type.
 */
@Schema(description = "The related entity source of a KQI or KPI. A KQI draws its data from a number of sources,  including Key Performance Indicators (KPIs).  A KPI provides a measurement of a specific aspect  of the performance of a Service (whether it is a network- or a non-network-based Service) or a  group of Services of the same type.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class EntityRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public EntityRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The hyperlink to access an entity.
   * @return href
  **/
  @Schema(description = "The hyperlink to access an entity.")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public EntityRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of an entity.
   * @return id
  **/
  @Schema(description = "The identifier of an entity.")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EntityRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of an entity.
   * @return name
  **/
  @Schema(description = "The name of an entity.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EntityRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
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
    EntityRef entityRef = (EntityRef) o;
    return Objects.equals(this.href, entityRef.href) &&
        Objects.equals(this.id, entityRef.id) &&
        Objects.equals(this.name, entityRef.name) &&
        Objects.equals(this.referredType, entityRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

