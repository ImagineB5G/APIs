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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Individual represents a single human being (a man, woman or child). The
 * individual can be a customer, an employee or any other person that the
 * organization needs to store information about. Skipped properties: id,href
 */
@Schema(description = "Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class IndividualUpdate {
	@JsonProperty("aristocraticTitle")
	protected String aristocraticTitle = null;

	protected OffsetDateTime birthDate = null;

	@JsonProperty("countryOfBirth")
	protected String countryOfBirth = null;

	protected OffsetDateTime deathDate = null;

	@JsonProperty("familyName")
	protected String familyName = null;

	@JsonProperty("familyNamePrefix")
	protected String familyNamePrefix = null;

	@JsonProperty("formattedName")
	protected String formattedName = null;

	@JsonProperty("fullName")
	protected String fullName = null;

	@JsonProperty("gender")
	protected String gender = null;

	@JsonProperty("generation")
	protected String generation = null;

	@JsonProperty("givenName")
	protected String givenName = null;

	@JsonProperty("legalName")
	protected String legalName = null;

	@JsonProperty("location")
	protected String location = null;

	@JsonProperty("maritalStatus")
	protected String maritalStatus = null;

	@JsonProperty("middleName")
	protected String middleName = null;

	@JsonProperty("nationality")
	protected String nationality = null;

	@JsonProperty("placeOfBirth")
	protected String placeOfBirth = null;

	@JsonProperty("preferredGivenName")
	protected String preferredGivenName = null;

	@JsonProperty("title")
	protected String title = null;

	@JsonProperty("contactMedium")
	@Valid
	protected List<ContactMedium> contactMedium = null;

	@JsonProperty("creditRating")
	@Valid
	protected List<PartyCreditProfile> creditRating = null;

	@JsonProperty("disability")
	@Valid
	protected List<Disability> disability = null;

	@JsonProperty("externalReference")
	@Valid
	protected List<ExternalReference> externalReference = null;

	@JsonProperty("individualIdentification")
	@Valid
	protected List<IndividualIdentification> individualIdentification = null;

	@JsonProperty("languageAbility")
	@Valid
	protected List<LanguageAbility> languageAbility = null;

	@JsonProperty("otherName")
	@Valid
	protected List<OtherNameIndividual> otherName = null;

	@JsonProperty("partyCharacteristic")
	@Valid
	protected List<Characteristic> partyCharacteristic = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("skill")
	@Valid
	protected List<Skill> skill = null;

	@JsonProperty("status")
	protected IndividualStateType status = null;

	@JsonProperty("taxExemptionCertificate")
	@Valid
	protected List<TaxExemptionCertificate> taxExemptionCertificate = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@type")
	protected String type = null;

	public IndividualUpdate aristocraticTitle(String aristocraticTitle) {
		this.aristocraticTitle = aristocraticTitle;
		return this;
	}

	/**
	 * e.g. Baron, Graf, Earl,…
	 * 
	 * @return aristocraticTitle
	 **/
	@Schema(description = "e.g. Baron, Graf, Earl,…")

	public String getAristocraticTitle() {
		return aristocraticTitle;
	}

	public void setAristocraticTitle(String aristocraticTitle) {
		this.aristocraticTitle = aristocraticTitle;
	}

	public IndividualUpdate birthDate(OffsetDateTime birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	/**
	 * Birth date
	 * 
	 * @return birthDate
	 **/
	@Schema(description = "Birth date")

	@Valid

	@JsonProperty("birthDate")
	public String getBirthDateString() {
		if ( birthDate == null ) {
			return null;
		}
		return  birthDate.toString();
	}

	public OffsetDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(OffsetDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public IndividualUpdate countryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
		return this;
	}

	/**
	 * Country where the individual was born
	 * 
	 * @return countryOfBirth
	 **/
	@Schema(description = "Country where the individual was born")

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public IndividualUpdate deathDate(OffsetDateTime deathDate) {
		this.deathDate = deathDate;
		return this;
	}

	/**
	 * Date of death
	 * 
	 * @return deathDate
	 **/
	@Schema(description = "Date of death")

	@Valid

	@JsonProperty("deathDate")
	public String getDeathDateString() {
		if ( deathDate == null ) {
			return null;
		}
		return deathDate.toString();
	}

	public OffsetDateTime getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(OffsetDateTime deathDate) {
		this.deathDate = deathDate;
	}

	public IndividualUpdate familyName(String familyName) {
		this.familyName = familyName;
		return this;
	}

	/**
	 * Contains the non-chosen or inherited name. Also known as last name in the
	 * Western context
	 * 
	 * @return familyName
	 **/
	@Schema(description = "Contains the non-chosen or inherited name. Also known as last name in the Western context")

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public IndividualUpdate familyNamePrefix(String familyNamePrefix) {
		this.familyNamePrefix = familyNamePrefix;
		return this;
	}

	/**
	 * Family name prefix
	 * 
	 * @return familyNamePrefix
	 **/
	@Schema(description = "Family name prefix")

	public String getFamilyNamePrefix() {
		return familyNamePrefix;
	}

	public void setFamilyNamePrefix(String familyNamePrefix) {
		this.familyNamePrefix = familyNamePrefix;
	}

	public IndividualUpdate formattedName(String formattedName) {
		this.formattedName = formattedName;
		return this;
	}

	/**
	 * A fully formatted name in one string with all of its pieces in their proper
	 * place and all of the necessary punctuation. Useful for specific contexts
	 * (Chinese, Japanese, Korean,…)
	 * 
	 * @return formattedName
	 **/
	@Schema(description = "A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)")

	public String getFormattedName() {
		return formattedName;
	}

	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}

	public IndividualUpdate fullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	/**
	 * Full name flatten (first, middle, and last names)
	 * 
	 * @return fullName
	 **/
	@Schema(description = "Full name flatten (first, middle, and last names)")

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public IndividualUpdate gender(String gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Gender
	 * 
	 * @return gender
	 **/
	@Schema(description = "Gender")

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public IndividualUpdate generation(String generation) {
		this.generation = generation;
		return this;
	}

	/**
	 * e.g.. Sr, Jr, III (the third),…
	 * 
	 * @return generation
	 **/
	@Schema(description = "e.g.. Sr, Jr, III (the third),…")

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public IndividualUpdate givenName(String givenName) {
		this.givenName = givenName;
		return this;
	}

	/**
	 * First name of the individual
	 * 
	 * @return givenName
	 **/
	@Schema(description = "First name of the individual")

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public IndividualUpdate legalName(String legalName) {
		this.legalName = legalName;
		return this;
	}

	/**
	 * Legal name or birth name (name one has for official purposes)
	 * 
	 * @return legalName
	 **/
	@Schema(description = "Legal name or birth name (name one has for official purposes)")

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public IndividualUpdate location(String location) {
		this.location = location;
		return this;
	}

	/**
	 * Temporary current location od the individual (may be used if the individual
	 * has approved its sharing)
	 * 
	 * @return location
	 **/
	@Schema(description = "Temporary current location od the individual (may be used if the individual has approved its sharing)")

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public IndividualUpdate maritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
		return this;
	}

	/**
	 * Marital status (married, divorced, widow ...)
	 * 
	 * @return maritalStatus
	 **/
	@Schema(description = "Marital status (married, divorced, widow ...)")

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public IndividualUpdate middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	/**
	 * Middles name or initial
	 * 
	 * @return middleName
	 **/
	@Schema(description = "Middles name or initial")

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public IndividualUpdate nationality(String nationality) {
		this.nationality = nationality;
		return this;
	}

	/**
	 * Nationality
	 * 
	 * @return nationality
	 **/
	@Schema(description = "Nationality")

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public IndividualUpdate placeOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
		return this;
	}

	/**
	 * Reference to the place where the individual was born
	 * 
	 * @return placeOfBirth
	 **/
	@Schema(description = "Reference to the place where the individual was born")

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public IndividualUpdate preferredGivenName(String preferredGivenName) {
		this.preferredGivenName = preferredGivenName;
		return this;
	}

	/**
	 * Contains the chosen name by which the individual prefers to be addressed.
	 * Note: This name may be a name other than a given name, such as a nickname
	 * 
	 * @return preferredGivenName
	 **/
	@Schema(description = "Contains the chosen name by which the individual prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname")

	public String getPreferredGivenName() {
		return preferredGivenName;
	}

	public void setPreferredGivenName(String preferredGivenName) {
		this.preferredGivenName = preferredGivenName;
	}

	public IndividualUpdate title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...
	 * 
	 * @return title
	 **/
	@Schema(description = "Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public IndividualUpdate contactMedium(List<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
		return this;
	}

	public IndividualUpdate addContactMediumItem(ContactMedium contactMediumItem) {
		if (this.contactMedium == null) {
			this.contactMedium = new ArrayList<>();
		}
		this.contactMedium.add(contactMediumItem);
		return this;
	}

	/**
	 * Get contactMedium
	 * 
	 * @return contactMedium
	 **/
	@Schema(description = "")

	@Valid

	public List<ContactMedium> getContactMedium() {
		return contactMedium;
	}

	public void setContactMedium(List<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
	}

	public IndividualUpdate creditRating(List<PartyCreditProfile> creditRating) {
		this.creditRating = creditRating;
		return this;
	}

	public IndividualUpdate addCreditRatingItem(PartyCreditProfile creditRatingItem) {
		if (this.creditRating == null) {
			this.creditRating = new ArrayList<>();
		}
		this.creditRating.add(creditRatingItem);
		return this;
	}

	/**
	 * Get creditRating
	 * 
	 * @return creditRating
	 **/
	@Schema(description = "")

	@Valid

	public List<PartyCreditProfile> getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(List<PartyCreditProfile> creditRating) {
		this.creditRating = creditRating;
	}

	public IndividualUpdate disability(List<Disability> disability) {
		this.disability = disability;
		return this;
	}

	public IndividualUpdate addDisabilityItem(Disability disabilityItem) {
		if (this.disability == null) {
			this.disability = new ArrayList<>();
		}
		this.disability.add(disabilityItem);
		return this;
	}

	/**
	 * Get disability
	 * 
	 * @return disability
	 **/
	@Schema(description = "")

	@Valid

	public List<Disability> getDisability() {
		return disability;
	}

	public void setDisability(List<Disability> disability) {
		this.disability = disability;
	}

	public IndividualUpdate externalReference(List<ExternalReference> externalReference) {
		this.externalReference = externalReference;
		return this;
	}

	public IndividualUpdate addExternalReferenceItem(ExternalReference externalReferenceItem) {
		if (this.externalReference == null) {
			this.externalReference = new ArrayList<>();
		}
		this.externalReference.add(externalReferenceItem);
		return this;
	}

	/**
	 * Get externalReference
	 * 
	 * @return externalReference
	 **/
	@Schema(description = "")

	@Valid

	public List<ExternalReference> getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(List<ExternalReference> externalReference) {
		this.externalReference = externalReference;
	}

	public IndividualUpdate individualIdentification(List<IndividualIdentification> individualIdentification) {
		this.individualIdentification = individualIdentification;
		return this;
	}

	public IndividualUpdate addIndividualIdentificationItem(IndividualIdentification individualIdentificationItem) {
		if (this.individualIdentification == null) {
			this.individualIdentification = new ArrayList<>();
		}
		this.individualIdentification.add(individualIdentificationItem);
		return this;
	}

	/**
	 * Get individualIdentification
	 * 
	 * @return individualIdentification
	 **/
	@Schema(description = "")

	@Valid

	public List<IndividualIdentification> getIndividualIdentification() {
		return individualIdentification;
	}

	public void setIndividualIdentification(List<IndividualIdentification> individualIdentification) {
		this.individualIdentification = individualIdentification;
	}

	public IndividualUpdate languageAbility(List<LanguageAbility> languageAbility) {
		this.languageAbility = languageAbility;
		return this;
	}

	public IndividualUpdate addLanguageAbilityItem(LanguageAbility languageAbilityItem) {
		if (this.languageAbility == null) {
			this.languageAbility = new ArrayList<>();
		}
		this.languageAbility.add(languageAbilityItem);
		return this;
	}

	/**
	 * Get languageAbility
	 * 
	 * @return languageAbility
	 **/
	@Schema(description = "")

	@Valid

	public List<LanguageAbility> getLanguageAbility() {
		return languageAbility;
	}

	public void setLanguageAbility(List<LanguageAbility> languageAbility) {
		this.languageAbility = languageAbility;
	}

	public IndividualUpdate otherName(List<OtherNameIndividual> otherName) {
		this.otherName = otherName;
		return this;
	}

	public IndividualUpdate addOtherNameItem(OtherNameIndividual otherNameItem) {
		if (this.otherName == null) {
			this.otherName = new ArrayList<>();
		}
		this.otherName.add(otherNameItem);
		return this;
	}

	/**
	 * Get otherName
	 * 
	 * @return otherName
	 **/
	@Schema(description = "")

	@Valid

	public List<OtherNameIndividual> getOtherName() {
		return otherName;
	}

	public void setOtherName(List<OtherNameIndividual> otherName) {
		this.otherName = otherName;
	}

	public IndividualUpdate partyCharacteristic(List<Characteristic> partyCharacteristic) {
		this.partyCharacteristic = partyCharacteristic;
		return this;
	}

	public IndividualUpdate addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
		if (this.partyCharacteristic == null) {
			this.partyCharacteristic = new ArrayList<>();
		}
		this.partyCharacteristic.add(partyCharacteristicItem);
		return this;
	}

	/**
	 * Get partyCharacteristic
	 * 
	 * @return partyCharacteristic
	 **/
	@Schema(description = "")

	@Valid

	public List<Characteristic> getPartyCharacteristic() {
		return partyCharacteristic;
	}

	public void setPartyCharacteristic(List<Characteristic> partyCharacteristic) {
		this.partyCharacteristic = partyCharacteristic;
	}

	public IndividualUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public IndividualUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Get relatedParty
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "")

	@Valid

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public IndividualUpdate skill(List<Skill> skill) {
		this.skill = skill;
		return this;
	}

	public IndividualUpdate addSkillItem(Skill skillItem) {
		if (this.skill == null) {
			this.skill = new ArrayList<>();
		}
		this.skill.add(skillItem);
		return this;
	}

	/**
	 * Get skill
	 * 
	 * @return skill
	 **/
	@Schema(description = "")

	@Valid

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	public IndividualUpdate status(IndividualStateType status) {
		this.status = status;
		return this;
	}

	/**
	 * Status of the individual
	 * 
	 * @return status
	 **/
	@Schema(description = "Status of the individual")

	@Valid

	public IndividualStateType getStatus() {
		return status;
	}

	public void setStatus(IndividualStateType status) {
		this.status = status;
	}

	public IndividualUpdate taxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
		this.taxExemptionCertificate = taxExemptionCertificate;
		return this;
	}

	public IndividualUpdate addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
		if (this.taxExemptionCertificate == null) {
			this.taxExemptionCertificate = new ArrayList<>();
		}
		this.taxExemptionCertificate.add(taxExemptionCertificateItem);
		return this;
	}

	/**
	 * Get taxExemptionCertificate
	 * 
	 * @return taxExemptionCertificate
	 **/
	@Schema(description = "")

	@Valid

	public List<TaxExemptionCertificate> getTaxExemptionCertificate() {
		return taxExemptionCertificate;
	}

	public void setTaxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
		this.taxExemptionCertificate = taxExemptionCertificate;
	}

	public IndividualUpdate baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public IndividualUpdate schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public IndividualUpdate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return type
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class entity name")

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
		IndividualUpdate individualUpdate = (IndividualUpdate) o;
		return Objects.equals(this.aristocraticTitle, individualUpdate.aristocraticTitle)
				&& Objects.equals(this.birthDate, individualUpdate.birthDate)
				&& Objects.equals(this.countryOfBirth, individualUpdate.countryOfBirth)
				&& Objects.equals(this.deathDate, individualUpdate.deathDate)
				&& Objects.equals(this.familyName, individualUpdate.familyName)
				&& Objects.equals(this.familyNamePrefix, individualUpdate.familyNamePrefix)
				&& Objects.equals(this.formattedName, individualUpdate.formattedName)
				&& Objects.equals(this.fullName, individualUpdate.fullName)
				&& Objects.equals(this.gender, individualUpdate.gender)
				&& Objects.equals(this.generation, individualUpdate.generation)
				&& Objects.equals(this.givenName, individualUpdate.givenName)
				&& Objects.equals(this.legalName, individualUpdate.legalName)
				&& Objects.equals(this.location, individualUpdate.location)
				&& Objects.equals(this.maritalStatus, individualUpdate.maritalStatus)
				&& Objects.equals(this.middleName, individualUpdate.middleName)
				&& Objects.equals(this.nationality, individualUpdate.nationality)
				&& Objects.equals(this.placeOfBirth, individualUpdate.placeOfBirth)
				&& Objects.equals(this.preferredGivenName, individualUpdate.preferredGivenName)
				&& Objects.equals(this.title, individualUpdate.title)
				&& Objects.equals(this.contactMedium, individualUpdate.contactMedium)
				&& Objects.equals(this.creditRating, individualUpdate.creditRating)
				&& Objects.equals(this.disability, individualUpdate.disability)
				&& Objects.equals(this.externalReference, individualUpdate.externalReference)
				&& Objects.equals(this.individualIdentification, individualUpdate.individualIdentification)
				&& Objects.equals(this.languageAbility, individualUpdate.languageAbility)
				&& Objects.equals(this.otherName, individualUpdate.otherName)
				&& Objects.equals(this.partyCharacteristic, individualUpdate.partyCharacteristic)
				&& Objects.equals(this.relatedParty, individualUpdate.relatedParty)
				&& Objects.equals(this.skill, individualUpdate.skill)
				&& Objects.equals(this.status, individualUpdate.status)
				&& Objects.equals(this.taxExemptionCertificate, individualUpdate.taxExemptionCertificate)
				&& Objects.equals(this.baseType, individualUpdate.baseType)
				&& Objects.equals(this.schemaLocation, individualUpdate.schemaLocation)
				&& Objects.equals(this.type, individualUpdate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aristocraticTitle, birthDate, countryOfBirth, deathDate, familyName, familyNamePrefix,
				formattedName, fullName, gender, generation, givenName, legalName, location, maritalStatus, middleName,
				nationality, placeOfBirth, preferredGivenName, title, contactMedium, creditRating, disability,
				externalReference, individualIdentification, languageAbility, otherName, partyCharacteristic,
				relatedParty, skill, status, taxExemptionCertificate, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class IndividualUpdate {\n");

		sb.append("    aristocraticTitle: ").append(toIndentedString(aristocraticTitle)).append("\n");
		sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
		sb.append("    countryOfBirth: ").append(toIndentedString(countryOfBirth)).append("\n");
		sb.append("    deathDate: ").append(toIndentedString(deathDate)).append("\n");
		sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
		sb.append("    familyNamePrefix: ").append(toIndentedString(familyNamePrefix)).append("\n");
		sb.append("    formattedName: ").append(toIndentedString(formattedName)).append("\n");
		sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    generation: ").append(toIndentedString(generation)).append("\n");
		sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
		sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
		sb.append("    location: ").append(toIndentedString(location)).append("\n");
		sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
		sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
		sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
		sb.append("    placeOfBirth: ").append(toIndentedString(placeOfBirth)).append("\n");
		sb.append("    preferredGivenName: ").append(toIndentedString(preferredGivenName)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
		sb.append("    creditRating: ").append(toIndentedString(creditRating)).append("\n");
		sb.append("    disability: ").append(toIndentedString(disability)).append("\n");
		sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
		sb.append("    individualIdentification: ").append(toIndentedString(individualIdentification)).append("\n");
		sb.append("    languageAbility: ").append(toIndentedString(languageAbility)).append("\n");
		sb.append("    otherName: ").append(toIndentedString(otherName)).append("\n");
		sb.append("    partyCharacteristic: ").append(toIndentedString(partyCharacteristic)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    skill: ").append(toIndentedString(skill)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    taxExemptionCertificate: ").append(toIndentedString(taxExemptionCertificate)).append("\n");
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
