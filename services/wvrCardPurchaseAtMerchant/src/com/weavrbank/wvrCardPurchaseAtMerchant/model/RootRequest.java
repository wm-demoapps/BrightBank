/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.weavrbank.wvrCardPurchaseAtMerchant.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.weavrbank.wvrCardPurchaseAtMerchant.model.RequestTransactionAmount;
/**
 * RootRequest
 */

public class RootRequest {
  @JsonProperty("transactionAmount")
  private RequestTransactionAmount transactionAmount = null;

  @JsonProperty("merchantName")
  private String merchantName = null;

  public RootRequest transactionAmount(RequestTransactionAmount transactionAmount) {
    this.transactionAmount = transactionAmount;
    return this;
  }

   /**
   * Get transactionAmount
   * @return transactionAmount
  **/
  public RequestTransactionAmount getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(RequestTransactionAmount transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public RootRequest merchantName(String merchantName) {
    this.merchantName = merchantName;
    return this;
  }

   /**
   * Get merchantName
   * @return merchantName
  **/
  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RootRequest RootRequest = (RootRequest) o;
    return Objects.equals(this.transactionAmount, RootRequest.transactionAmount) &&
        Objects.equals(this.merchantName, RootRequest.merchantName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionAmount, merchantName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RootRequest {\n");
    
    sb.append("    transactionAmount: ").append(toIndentedString(transactionAmount)).append("\n");
    sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
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
