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
package io.openslice.tmf.am651.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * A part of the agreement expressed in terms of a product offering and possibly including specific terms and conditions.
 */
@Schema(description = "A part of the agreement expressed in terms of a product offering and possibly including specific terms and conditions.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementItem   {
  @JsonProperty("productOffering")
  @Valid
  private List<ProductOfferingRef> productOffering = null;

  @JsonProperty("termOrCondition")
  @Valid
  private List<AgreementTermOrCondition> termOrCondition = null;

  @JsonProperty("@type")
  private String type = null;

  public AgreementItem productOffering(List<ProductOfferingRef> productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public AgreementItem addProductOfferingItem(ProductOfferingRef productOfferingItem) {
    if (this.productOffering == null) {
      this.productOffering = new ArrayList<>();
    }
    this.productOffering.add(productOfferingItem);
    return this;
  }

  /**
   * Get productOffering
   * @return productOffering
  **/
  @Schema(description = "")

  @Valid

  public List<ProductOfferingRef> getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(List<ProductOfferingRef> productOffering) {
    this.productOffering = productOffering;
  }

  public AgreementItem termOrCondition(List<AgreementTermOrCondition> termOrCondition) {
    this.termOrCondition = termOrCondition;
    return this;
  }

  public AgreementItem addTermOrConditionItem(AgreementTermOrCondition termOrConditionItem) {
    if (this.termOrCondition == null) {
      this.termOrCondition = new ArrayList<>();
    }
    this.termOrCondition.add(termOrConditionItem);
    return this;
  }

  /**
   * Get termOrCondition
   * @return termOrCondition
  **/
  @Schema(description = "")

  @Valid

  public List<AgreementTermOrCondition> getTermOrCondition() {
    return termOrCondition;
  }

  public void setTermOrCondition(List<AgreementTermOrCondition> termOrCondition) {
    this.termOrCondition = termOrCondition;
  }

  public AgreementItem type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgreementItem agreementItem = (AgreementItem) o;
    return Objects.equals(this.productOffering, agreementItem.productOffering) &&
        Objects.equals(this.termOrCondition, agreementItem.termOrCondition) &&
        Objects.equals(this.type, agreementItem.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productOffering, termOrCondition, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementItem {\n");
    
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    termOrCondition: ").append(toIndentedString(termOrCondition)).append("\n");
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

