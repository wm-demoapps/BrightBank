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
import java.util.List;
/**
 * IdentityLevelSpendRules
 */

public class IdentityLevelSpendRules extends CommonLevelSpendRules {
  @JsonProperty("minTransactionAmount")
  private Long minTransactionAmount = null;

  @JsonProperty("maxTransactionAmount")
  private Long maxTransactionAmount = null;

  public IdentityLevelSpendRules minTransactionAmount(Long minTransactionAmount) {
    this.minTransactionAmount = minTransactionAmount;
    return this;
  }

   /**
   * The minimum transaction amount, in card currency, that is allowed. If the transaction amount is less than this value, then the transaction will be declined. Omit this, or set to 0 if no maximum transaction amount is to be set.
   * @return minTransactionAmount
  **/
  public Long getMinTransactionAmount() {
    return minTransactionAmount;
  }

  public void setMinTransactionAmount(Long minTransactionAmount) {
    this.minTransactionAmount = minTransactionAmount;
  }

  public IdentityLevelSpendRules maxTransactionAmount(Long maxTransactionAmount) {
    this.maxTransactionAmount = maxTransactionAmount;
    return this;
  }

   /**
   * The maximum transaction amount, in card currency, that is allowed. If the transaction amount is greater than this value, then the transaction will be declined.
   * @return maxTransactionAmount
  **/
  public Long getMaxTransactionAmount() {
    return maxTransactionAmount;
  }

  public void setMaxTransactionAmount(Long maxTransactionAmount) {
    this.maxTransactionAmount = maxTransactionAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityLevelSpendRules IdentityLevelSpendRules = (IdentityLevelSpendRules) o;
    return Objects.equals(this.minTransactionAmount, IdentityLevelSpendRules.minTransactionAmount) &&
        Objects.equals(this.maxTransactionAmount, IdentityLevelSpendRules.maxTransactionAmount) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minTransactionAmount, maxTransactionAmount, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityLevelSpendRules {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    minTransactionAmount: ").append(toIndentedString(minTransactionAmount)).append("\n");
    sb.append("    maxTransactionAmount: ").append(toIndentedString(maxTransactionAmount)).append("\n");
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