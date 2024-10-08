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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Error
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class Error   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("reason")
  private Integer reason = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("referenceError")
  private String referenceError = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Application related code.
   * @return code
  **/
  @Schema(description = "Application related code.")
  @NotNull


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Error reason(Integer reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Text that explains the reason for error.
   * @return reason
  **/
  @Schema(description = "Text that explains the reason for error.")
  @NotNull


  public Integer getReason() {
    return reason;
  }

  public void setReason(Integer reason) {
    this.reason = reason;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * (optional) Text that provide more details and corrective actions related to the error.
   * @return message
  **/
  @Schema(description = "(optional) Text that provide more details and corrective actions related to the error.")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * (optional) http error code extension like 400-2
   * @return status
  **/
  @Schema(description = "(optional) http error code extension like 400-2")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Error referenceError(String referenceError) {
    this.referenceError = referenceError;
    return this;
  }

  /**
   * (optional) A URL to online documentation that provides more information about the error.
   * @return referenceError
  **/
  @Schema(description = "(optional) A URL to online documentation that provides more information about the error.")


  public String getReferenceError() {
    return referenceError;
  }

  public void setReferenceError(String referenceError) {
    this.referenceError = referenceError;
  }

  public Error type(String type) {
    this.type = type;
    return this;
  }

  /**
   * (optional) The class type of a REST resource.
   * @return type
  **/
  @Schema(description = "(optional) The class type of a REST resource.")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Error schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * (optional) A link to the schema describing a REST resource.
   * @return schemaLocation
  **/
  @Schema(description = "(optional) A link to the schema describing a REST resource.")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.reason, error.reason) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.referenceError, error.referenceError) &&
        Objects.equals(this.type, error.type) &&
        Objects.equals(this.schemaLocation, error.schemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, reason, message, status, referenceError, type, schemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    referenceError: ").append(toIndentedString(referenceError)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

