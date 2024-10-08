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
package io.openslice.tmf.common.model;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;

/**
 * A period of time, either as a deadline (endDateTime only) a startDateTime
 * only, or both
 */
@Schema(description = "A period of time, either as a deadline (endDateTime only) a startDateTime only, or both")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Embeddable
public class TimePeriod {
	private OffsetDateTime endDateTime = null;

	private OffsetDateTime startDateTime = null;
	
	public TimePeriod() {
		this.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
		this.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(20) );	
	}

	public TimePeriod(TimePeriod src) {
		this();
		if ( src!= null) {
			this.setStartDateTime(src.getStartDateTime());
			this.setEndDateTime(  src.getEndDateTime() );			
		}
	}

	public TimePeriod endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
	}

	/**
	 * End of the time period, using IETC-RFC-3339 format
	 * 
	 * @return endDateTime
	 **/
	@Schema(description = "End of the time period, using IETC-RFC-3339 format")
	@Valid
	@JsonProperty("endDateTime")
	public String getEndDateTimeString() {
		return endDateTime.toString();
	}
	
	public OffsetDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public TimePeriod startDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
		return this;
	}


	public void setEndDateTime(String endDateTime) {
		this.endDateTime = OffsetDateTime.parse( endDateTime );
	}

	


	
	/**
	 * Start of the time period, using IETC-RFC-3339 format. If you define a start,
	 * you must also define an end
	 * 
	 * @return startDateTime
	 **/
	@Schema(description = "Start of the time period, using IETC-RFC-3339 format. If you define a start, you must also define an end")
	@Valid
	@JsonProperty("startDateTime")
	public String getStartDateTimeString() {
		return startDateTime.toString();
	}
	
	public OffsetDateTime getStartDateTime() {
		return startDateTime;
	}
	
	
	public void setStartDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public void setStartDateTime(String startDateTime) {
		if ( startDateTime!= null ) {
			this.startDateTime = OffsetDateTime.parse( startDateTime );
		}
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TimePeriod timePeriod = (TimePeriod) o;
		return Objects.equals(this.endDateTime, timePeriod.endDateTime)
				&& Objects.equals(this.startDateTime, timePeriod.startDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDateTime, startDateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TimePeriod {\n");

		sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
		sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
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

	public void copyFromObj(TimePeriod validFor) {
		if (validFor != null) {
			this.startDateTime = validFor.startDateTime;
			this.endDateTime = validFor.endDateTime;
		}

	}
}
