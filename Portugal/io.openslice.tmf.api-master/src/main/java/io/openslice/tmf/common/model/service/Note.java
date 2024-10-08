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
package io.openslice.tmf.common.model.service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.validation.Valid;

/**
 * Extra information about a given entity
 */
@Schema(description = "Extra information about a given entity")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "Note")
public class Note extends BaseRootEntity {
	@JsonProperty("author")
	private String author = null;

	private OffsetDateTime date = null;

	@JsonProperty("system")
	private String system = null;

	@Lob
	@Column(name = "LTEXT", columnDefinition = "LONGTEXT")
	@JsonProperty("text")
	private String text = null;

	public Note author(String author) {
		this.author = author;
		return this;
	}

	/**
	 * Author of the note
	 * 
	 * @return author
	 **/
	@Schema(description = "Author of the note")

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Note date(OffsetDateTime date) {
		this.date = date;
		return this;
	}

	/**
	 * Date of the note
	 * 
	 * @return date
	 **/
	@Schema(description = "Date of the note")

	@Valid

	@JsonProperty("date")
	public String getDateString() {
		if (this.date == null) {
			return null;
		}
		return this.date.toString();
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(String adate) {
		if (adate!=null) {
			this.date = OffsetDateTime.parse( adate );
			
		}
	}
	


	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public Note system(String system) {
		this.system = system;
		return this;
	}

	/**
	 * Describes the system from which the action related to this note was done
	 * 
	 * @return system
	 **/
	@Schema(description = "Describes the system from which the action related to this note was done")

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Note text(String text) {
		this.text = text;
		if ( date == null) {
			this.setDate(  OffsetDateTime.now(ZoneOffset.UTC).toString() );			
		}
		return this;
	}

	/**
	 * Text of the note
	 * 
	 * @return text
	 **/
	@Schema(description = "Text of the note")

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		this.setDate(  OffsetDateTime.now(ZoneOffset.UTC).toString() );
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Note note = (Note) o;
		return Objects.equals(this.author, note.author) && Objects.equals(this.date, note.date)
				&& Objects.equals(this.system, note.system) && Objects.equals(this.text, note.text)
				&& Objects.equals(this.baseType, note.baseType)
				&& Objects.equals(this.schemaLocation, note.schemaLocation) && Objects.equals(this.type, note.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(author, date, system, text, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Note {\n");

		sb.append("    author: ").append(toIndentedString(author)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    system: ").append(toIndentedString(system)).append("\n");
		sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
