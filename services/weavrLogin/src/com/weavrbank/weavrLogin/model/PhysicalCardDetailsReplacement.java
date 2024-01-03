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
 * Indicates if the physical card is replaced by another card.
 */

public class PhysicalCardDetailsReplacement {
  /**
   * The reason why the physical card was replaced.   - DAMAGED: The physical card was damaged and cannot be used at a physical terminal.   - LOST_STOLEN: The physical card was either lost or stolen and cannot be used.   - EXPIRED: The physical card expired. 
   */
  public enum ReplacementReasonEnum {
    DAMAGED("DAMAGED"),
    LOST_STOLEN("LOST_STOLEN"),
    EXPIRED("EXPIRED");

    private String value;

    ReplacementReasonEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static ReplacementReasonEnum fromValue(String input) {
      for (ReplacementReasonEnum b : ReplacementReasonEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("replacementReason")
  private ReplacementReasonEnum replacementReason = null;

  @JsonProperty("replacementId")
  private String replacementId = null;

  public PhysicalCardDetailsReplacement replacementReason(ReplacementReasonEnum replacementReason) {
    this.replacementReason = replacementReason;
    return this;
  }

   /**
   * The reason why the physical card was replaced.   - DAMAGED: The physical card was damaged and cannot be used at a physical terminal.   - LOST_STOLEN: The physical card was either lost or stolen and cannot be used.   - EXPIRED: The physical card expired. 
   * @return replacementReason
  **/
  public ReplacementReasonEnum getReplacementReason() {
    return replacementReason;
  }

  public void setReplacementReason(ReplacementReasonEnum replacementReason) {
    this.replacementReason = replacementReason;
  }

  public PhysicalCardDetailsReplacement replacementId(String replacementId) {
    this.replacementId = replacementId;
    return this;
  }

   /**
   * The unique identifier of the new card that replaces this card.
   * @return replacementId
  **/
  public String getReplacementId() {
    return replacementId;
  }

  public void setReplacementId(String replacementId) {
    this.replacementId = replacementId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalCardDetailsReplacement PhysicalCardDetails_replacement = (PhysicalCardDetailsReplacement) o;
    return Objects.equals(this.replacementReason, PhysicalCardDetails_replacement.replacementReason) &&
        Objects.equals(this.replacementId, PhysicalCardDetails_replacement.replacementId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replacementReason, replacementId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalCardDetailsReplacement {\n");
    
    sb.append("    replacementReason: ").append(toIndentedString(replacementReason)).append("\n");
    sb.append("    replacementId: ").append(toIndentedString(replacementId)).append("\n");
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