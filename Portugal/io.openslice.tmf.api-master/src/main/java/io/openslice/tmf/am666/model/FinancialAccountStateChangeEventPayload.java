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
package io.openslice.tmf.am666.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The event data structure
 */
@Schema(description = "The event data structure")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class FinancialAccountStateChangeEventPayload   {
  @JsonProperty("financialAccount")
  private FinancialAccount financialAccount = null;

  public FinancialAccountStateChangeEventPayload financialAccount(FinancialAccount financialAccount) {
    this.financialAccount = financialAccount;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return financialAccount
  **/
  @Schema(description = "The involved resource data for the event")

  @Valid

  public FinancialAccount getFinancialAccount() {
    return financialAccount;
  }

  public void setFinancialAccount(FinancialAccount financialAccount) {
    this.financialAccount = financialAccount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialAccountStateChangeEventPayload financialAccountStateChangeEventPayload = (FinancialAccountStateChangeEventPayload) o;
    return Objects.equals(this.financialAccount, financialAccountStateChangeEventPayload.financialAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financialAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialAccountStateChangeEventPayload {\n");
    
    sb.append("    financialAccount: ").append(toIndentedString(financialAccount)).append("\n");
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

