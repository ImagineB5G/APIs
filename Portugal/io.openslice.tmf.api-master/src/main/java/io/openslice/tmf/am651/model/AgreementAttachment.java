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

/**
 * Represents a complementary piece of information to describe the agreement. Could be a document, picture, a video or any kind of multimedia content.
 */
@Schema(description = "Represents a complementary piece of information to describe the agreement. Could be a document, picture, a video or any kind of multimedia content.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementAttachment   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("type")
  private String typeAgreementAttachment = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("@type")
  private String type = null;

  public AgreementAttachment href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the attachment
   * @return href
  **/
  @Schema(description = "Reference of the attachment")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AgreementAttachment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the attachment
   * @return id
  **/
  @Schema(description = "Unique identifier of the attachment")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AgreementAttachment typeAgreementAttachment(String type) {
    this.type = type;
    return this;
  }

  /**
   * Attachment type such as video, picture
   * @return type
  **/
  @Schema(description = "Attachment type such as video, picture")


  public String getTypeAgreementAttachment() {
    return typeAgreementAttachment;
  }

  public void setTypeAgreementAttachment(String type) {
    this.typeAgreementAttachment = type;
  }

  public AgreementAttachment url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Uniform Resource Locator, is a web page address (a subset of URI)
   * @return url
  **/
  @Schema(description = "Uniform Resource Locator, is a web page address (a subset of URI)")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public AgreementAttachment type(String type) {
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
    AgreementAttachment agreementAttachment = (AgreementAttachment) o;
    return Objects.equals(this.href, agreementAttachment.href) &&
        Objects.equals(this.id, agreementAttachment.id) &&
        Objects.equals(this.type, agreementAttachment.type) &&
        Objects.equals(this.url, agreementAttachment.url) &&
        Objects.equals(this.type, agreementAttachment.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, type, url, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementAttachment {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

