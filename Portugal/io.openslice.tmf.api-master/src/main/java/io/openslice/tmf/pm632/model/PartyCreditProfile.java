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
package io.openslice.tmf.pm632.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

/**
 * An individual might be evaluated for its worthiness and this evaluation might be based on a credit rating given by a credit agency.
 */
@Schema(description = "An individual might be evaluated for its worthiness and this evaluation might be based on a credit rating given by a credit agency.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")


@Entity
public class PartyCreditProfile extends BaseRootEntity  {
  @JsonProperty("creditAgencyName")
  private String creditAgencyName = null;

  @JsonProperty("creditAgencyType")
  private String creditAgencyType = null;

  @JsonProperty("ratingReference")
  private String ratingReference = null;

  @JsonProperty("ratingScore")
  private Integer ratingScore = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;


  public PartyCreditProfile creditAgencyName(String creditAgencyName) {
    this.creditAgencyName = creditAgencyName;
    return this;
  }

  /**
   * Name of the credit agency giving the score
   * @return creditAgencyName
  **/
  @Schema(description = "Name of the credit agency giving the score")


  public String getCreditAgencyName() {
    return creditAgencyName;
  }

  public void setCreditAgencyName(String creditAgencyName) {
    this.creditAgencyName = creditAgencyName;
  }

  public PartyCreditProfile creditAgencyType(String creditAgencyType) {
    this.creditAgencyType = creditAgencyType;
    return this;
  }

  /**
   * Type of the credit agency giving the score
   * @return creditAgencyType
  **/
  @Schema(description = "Type of the credit agency giving the score")


  public String getCreditAgencyType() {
    return creditAgencyType;
  }

  public void setCreditAgencyType(String creditAgencyType) {
    this.creditAgencyType = creditAgencyType;
  }

  public PartyCreditProfile ratingReference(String ratingReference) {
    this.ratingReference = ratingReference;
    return this;
  }

  /**
   * Reference corresponding to the credit rating
   * @return ratingReference
  **/
  @Schema(description = "Reference corresponding to the credit rating")


  public String getRatingReference() {
    return ratingReference;
  }

  public void setRatingReference(String ratingReference) {
    this.ratingReference = ratingReference;
  }

  public PartyCreditProfile ratingScore(Integer ratingScore) {
    this.ratingScore = ratingScore;
    return this;
  }

  /**
   * A measure of a party’s creditworthiness calculated on the basis of a combination of factors such as their income and credit history
   * @return ratingScore
  **/
  @Schema(description = "A measure of a party’s creditworthiness calculated on the basis of a combination of factors such as their income and credit history")


  public Integer getRatingScore() {
    return ratingScore;
  }

  public void setRatingScore(Integer ratingScore) {
    this.ratingScore = ratingScore;
  }

  public PartyCreditProfile validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @Schema(description = "")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartyCreditProfile partyCreditProfile = (PartyCreditProfile) o;
    return Objects.equals(this.creditAgencyName, partyCreditProfile.creditAgencyName) &&
        Objects.equals(this.creditAgencyType, partyCreditProfile.creditAgencyType) &&
        Objects.equals(this.ratingReference, partyCreditProfile.ratingReference) &&
        Objects.equals(this.ratingScore, partyCreditProfile.ratingScore) &&
        Objects.equals(this.validFor, partyCreditProfile.validFor) &&
        Objects.equals(this.baseType, partyCreditProfile.baseType) &&
        Objects.equals(this.schemaLocation, partyCreditProfile.schemaLocation) &&
        Objects.equals(this.type, partyCreditProfile.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditAgencyName, creditAgencyType, ratingReference, ratingScore, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyCreditProfile {\n");
    
    sb.append("    creditAgencyName: ").append(toIndentedString(creditAgencyName)).append("\n");
    sb.append("    creditAgencyType: ").append(toIndentedString(creditAgencyType)).append("\n");
    sb.append("    ratingReference: ").append(toIndentedString(ratingReference)).append("\n");
    sb.append("    ratingScore: ").append(toIndentedString(ratingScore)).append("\n");
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

