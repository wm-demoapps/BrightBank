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
 * Fee
 */

public class Fee {
  @JsonProperty("source")
  private InstrumentId source = null;

  @JsonProperty("feeType")
  private String feeType = null;

  public Fee source(InstrumentId source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  public InstrumentId getSource() {
    return source;
  }

  public void setSource(InstrumentId source) {
    this.source = source;
  }

  public Fee feeType(String feeType) {
    this.feeType = feeType;
    return this;
  }

   /**
   * The fee type as defined in the Multi Portal.
   * @return feeType
  **/
  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fee Fee = (Fee) o;
    return Objects.equals(this.source, Fee.source) &&
        Objects.equals(this.feeType, Fee.feeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, feeType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fee {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
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