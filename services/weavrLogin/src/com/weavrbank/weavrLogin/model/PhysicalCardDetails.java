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
import com.weavrbank.weavrLogin.model.PhysicalCardDetailsReplacement;
/**
 * PhysicalCardDetails
 */

public class PhysicalCardDetails {
  @JsonProperty("deliveryTrackingMethod")
  private String deliveryTrackingMethod = null;

  @JsonProperty("pinBlocked")
  private Boolean pinBlocked = null;

  @JsonProperty("deliveryAddress")
  private DeliveryAddress deliveryAddress = null;

  @JsonProperty("deliveryMethod")
  private String deliveryMethod = null;

  @JsonProperty("pendingActivation")
  private Boolean pendingActivation = null;

  @JsonProperty("manufacturingState")
  private String manufacturingState = null;

  @JsonProperty("carrierType")
  private String carrierType = null;

  @JsonProperty("deliveryTrackingCode")
  private String deliveryTrackingCode = null;

  @JsonProperty("productReference")
  private String productReference = null;

  @JsonProperty("replacement")
  private PhysicalCardDetailsReplacement replacement = null;

  @JsonProperty("nameOnCardLine2")
  private String nameOnCardLine2 = null;

  public PhysicalCardDetails deliveryTrackingMethod(String deliveryTrackingMethod) {
    this.deliveryTrackingMethod = deliveryTrackingMethod;
    return this;
  }

   /**
   * Get deliveryTrackingMethod
   * @return deliveryTrackingMethod
  **/
  public String getDeliveryTrackingMethod() {
    return deliveryTrackingMethod;
  }

  public void setDeliveryTrackingMethod(String deliveryTrackingMethod) {
    this.deliveryTrackingMethod = deliveryTrackingMethod;
  }

  public PhysicalCardDetails pinBlocked(Boolean pinBlocked) {
    this.pinBlocked = pinBlocked;
    return this;
  }

   /**
   * Indicates if the physical card is blocked due to providing incorrect PINs.
   * @return pinBlocked
  **/
  public Boolean isPinBlocked() {
    return pinBlocked;
  }

  public void setPinBlocked(Boolean pinBlocked) {
    this.pinBlocked = pinBlocked;
  }

  public PhysicalCardDetails deliveryAddress(DeliveryAddress deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
    return this;
  }

   /**
   * Get deliveryAddress
   * @return deliveryAddress
  **/
  public DeliveryAddress getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public PhysicalCardDetails deliveryMethod(String deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
    return this;
  }

   /**
   * Get deliveryMethod
   * @return deliveryMethod
  **/
  public String getDeliveryMethod() {
    return deliveryMethod;
  }

  public void setDeliveryMethod(String deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }

  public PhysicalCardDetails pendingActivation(Boolean pendingActivation) {
    this.pendingActivation = pendingActivation;
    return this;
  }

   /**
   * Indicates if the physical card is activated for physical usage such as with physical terminals.
   * @return pendingActivation
  **/
  public Boolean isPendingActivation() {
    return pendingActivation;
  }

  public void setPendingActivation(Boolean pendingActivation) {
    this.pendingActivation = pendingActivation;
  }

  public PhysicalCardDetails manufacturingState(String manufacturingState) {
    this.manufacturingState = manufacturingState;
    return this;
  }

   /**
   * Get manufacturingState
   * @return manufacturingState
  **/
  public String getManufacturingState() {
    return manufacturingState;
  }

  public void setManufacturingState(String manufacturingState) {
    this.manufacturingState = manufacturingState;
  }

  public PhysicalCardDetails carrierType(String carrierType) {
    this.carrierType = carrierType;
    return this;
  }

   /**
   * Get carrierType
   * @return carrierType
  **/
  public String getCarrierType() {
    return carrierType;
  }

  public void setCarrierType(String carrierType) {
    this.carrierType = carrierType;
  }

  public PhysicalCardDetails deliveryTrackingCode(String deliveryTrackingCode) {
    this.deliveryTrackingCode = deliveryTrackingCode;
    return this;
  }

   /**
   * Get deliveryTrackingCode
   * @return deliveryTrackingCode
  **/
  public String getDeliveryTrackingCode() {
    return deliveryTrackingCode;
  }

  public void setDeliveryTrackingCode(String deliveryTrackingCode) {
    this.deliveryTrackingCode = deliveryTrackingCode;
  }

  public PhysicalCardDetails productReference(String productReference) {
    this.productReference = productReference;
    return this;
  }

   /**
   * The unique reference indicating the configuration of the physical card. Example the card design.
   * @return productReference
  **/
  public String getProductReference() {
    return productReference;
  }

  public void setProductReference(String productReference) {
    this.productReference = productReference;
  }

  public PhysicalCardDetails replacement(PhysicalCardDetailsReplacement replacement) {
    this.replacement = replacement;
    return this;
  }

   /**
   * Get replacement
   * @return replacement
  **/
  public PhysicalCardDetailsReplacement getReplacement() {
    return replacement;
  }

  public void setReplacement(PhysicalCardDetailsReplacement replacement) {
    this.replacement = replacement;
  }

  public PhysicalCardDetails nameOnCardLine2(String nameOnCardLine2) {
    this.nameOnCardLine2 = nameOnCardLine2;
    return this;
  }

   /**
   * Line 2 of the &#x27;name on card&#x27; field. This will be printed on the card.
   * @return nameOnCardLine2
  **/
  public String getNameOnCardLine2() {
    return nameOnCardLine2;
  }

  public void setNameOnCardLine2(String nameOnCardLine2) {
    this.nameOnCardLine2 = nameOnCardLine2;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalCardDetails PhysicalCardDetails = (PhysicalCardDetails) o;
    return Objects.equals(this.deliveryTrackingMethod, PhysicalCardDetails.deliveryTrackingMethod) &&
        Objects.equals(this.pinBlocked, PhysicalCardDetails.pinBlocked) &&
        Objects.equals(this.deliveryAddress, PhysicalCardDetails.deliveryAddress) &&
        Objects.equals(this.deliveryMethod, PhysicalCardDetails.deliveryMethod) &&
        Objects.equals(this.pendingActivation, PhysicalCardDetails.pendingActivation) &&
        Objects.equals(this.manufacturingState, PhysicalCardDetails.manufacturingState) &&
        Objects.equals(this.carrierType, PhysicalCardDetails.carrierType) &&
        Objects.equals(this.deliveryTrackingCode, PhysicalCardDetails.deliveryTrackingCode) &&
        Objects.equals(this.productReference, PhysicalCardDetails.productReference) &&
        Objects.equals(this.replacement, PhysicalCardDetails.replacement) &&
        Objects.equals(this.nameOnCardLine2, PhysicalCardDetails.nameOnCardLine2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deliveryTrackingMethod, pinBlocked, deliveryAddress, deliveryMethod, pendingActivation, manufacturingState, carrierType, deliveryTrackingCode, productReference, replacement, nameOnCardLine2);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalCardDetails {\n");
    
    sb.append("    deliveryTrackingMethod: ").append(toIndentedString(deliveryTrackingMethod)).append("\n");
    sb.append("    pinBlocked: ").append(toIndentedString(pinBlocked)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
    sb.append("    deliveryMethod: ").append(toIndentedString(deliveryMethod)).append("\n");
    sb.append("    pendingActivation: ").append(toIndentedString(pendingActivation)).append("\n");
    sb.append("    manufacturingState: ").append(toIndentedString(manufacturingState)).append("\n");
    sb.append("    carrierType: ").append(toIndentedString(carrierType)).append("\n");
    sb.append("    deliveryTrackingCode: ").append(toIndentedString(deliveryTrackingCode)).append("\n");
    sb.append("    productReference: ").append(toIndentedString(productReference)).append("\n");
    sb.append("    replacement: ").append(toIndentedString(replacement)).append("\n");
    sb.append("    nameOnCardLine2: ").append(toIndentedString(nameOnCardLine2)).append("\n");
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