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
 * InlineResponse2003
 */

public class InlineResponse2003 {
  @JsonProperty("passwordInfo")
  private PasswordInfo passwordInfo = null;

  @JsonProperty("token")
  private String token = null;

  public InlineResponse2003 passwordInfo(PasswordInfo passwordInfo) {
    this.passwordInfo = passwordInfo;
    return this;
  }

   /**
   * Get passwordInfo
   * @return passwordInfo
  **/
  public PasswordInfo getPasswordInfo() {
    return passwordInfo;
  }

  public void setPasswordInfo(PasswordInfo passwordInfo) {
    this.passwordInfo = passwordInfo;
  }

  public InlineResponse2003 token(String token) {
    this.token = token;
    return this;
  }

   /**
   * The authorisation token to be used in the Authorization header for secured operations.
   * @return token
  **/
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2003 inline_response_200_3 = (InlineResponse2003) o;
    return Objects.equals(this.passwordInfo, inline_response_200_3.passwordInfo) &&
        Objects.equals(this.token, inline_response_200_3.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passwordInfo, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2003 {\n");
    
    sb.append("    passwordInfo: ").append(toIndentedString(passwordInfo)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
