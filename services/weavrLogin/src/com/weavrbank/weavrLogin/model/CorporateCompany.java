/*
 * Weavr Multi Product API
 * Weavr Multi API provides a simple and flexible way to issue cards and accounts to your customers.  By integrating Weavr Multi API in your application you can embed banking capabilities within your app and provide a seamless experience for your customers.  # Authentication Each request to the Multi API must include an `api_key` that represents your account. You can obtain an API Key by registering for a Multi account [here](https://portal.weavr.io).  Almost all endpoints require a secondary authentication token `auth_token` that represents the user for whom the request is being executed.   <!-- ReDoc-Inject: <security-definitions> --> 
 *
 * OpenAPI spec version: 3.29.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.weavrbank.weavrLogin.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * CorporateCompany
 */

public class CorporateCompany {
  @JsonProperty("registeredAddress")
  private LegalAddress registeredAddress = null;

  @JsonProperty("incorporatedOn")
  private Date incorporatedOn = null;

  @JsonProperty("registrationNumber")
  private String registrationNumber = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("businessAddress")
  private Address businessAddress = null;

  @JsonProperty("countryOfRegistration")
  private String countryOfRegistration = null;

  public CorporateCompany registeredAddress(LegalAddress registeredAddress) {
    this.registeredAddress = registeredAddress;
    return this;
  }

   /**
   * Get registeredAddress
   * @return registeredAddress
  **/
  public LegalAddress getRegisteredAddress() {
    return registeredAddress;
  }

  public void setRegisteredAddress(LegalAddress registeredAddress) {
    this.registeredAddress = registeredAddress;
  }

  public CorporateCompany incorporatedOn(Date incorporatedOn) {
    this.incorporatedOn = incorporatedOn;
    return this;
  }

   /**
   * Get incorporatedOn
   * @return incorporatedOn
  **/
  public Date getIncorporatedOn() {
    return incorporatedOn;
  }

  public void setIncorporatedOn(Date incorporatedOn) {
    this.incorporatedOn = incorporatedOn;
  }

  public CorporateCompany registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

   /**
   * The company registration number.
   * @return registrationNumber
  **/
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public CorporateCompany name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The registered name of the company.
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CorporateCompany type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CorporateCompany businessAddress(Address businessAddress) {
    this.businessAddress = businessAddress;
    return this;
  }

   /**
   * Get businessAddress
   * @return businessAddress
  **/
  public Address getBusinessAddress() {
    return businessAddress;
  }

  public void setBusinessAddress(Address businessAddress) {
    this.businessAddress = businessAddress;
  }

  public CorporateCompany countryOfRegistration(String countryOfRegistration) {
    this.countryOfRegistration = countryOfRegistration;
    return this;
  }

   /**
   * The country of company registration in ISO 3166 alpha-2.
   * @return countryOfRegistration
  **/
  public String getCountryOfRegistration() {
    return countryOfRegistration;
  }

  public void setCountryOfRegistration(String countryOfRegistration) {
    this.countryOfRegistration = countryOfRegistration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CorporateCompany Corporate_company = (CorporateCompany) o;
    return Objects.equals(this.registeredAddress, Corporate_company.registeredAddress) &&
        Objects.equals(this.incorporatedOn, Corporate_company.incorporatedOn) &&
        Objects.equals(this.registrationNumber, Corporate_company.registrationNumber) &&
        Objects.equals(this.name, Corporate_company.name) &&
        Objects.equals(this.type, Corporate_company.type) &&
        Objects.equals(this.businessAddress, Corporate_company.businessAddress) &&
        Objects.equals(this.countryOfRegistration, Corporate_company.countryOfRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registeredAddress, incorporatedOn, registrationNumber, name, type, businessAddress, countryOfRegistration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CorporateCompany {\n");
    
    sb.append("    registeredAddress: ").append(toIndentedString(registeredAddress)).append("\n");
    sb.append("    incorporatedOn: ").append(toIndentedString(incorporatedOn)).append("\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    businessAddress: ").append(toIndentedString(businessAddress)).append("\n");
    sb.append("    countryOfRegistration: ").append(toIndentedString(countryOfRegistration)).append("\n");
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
