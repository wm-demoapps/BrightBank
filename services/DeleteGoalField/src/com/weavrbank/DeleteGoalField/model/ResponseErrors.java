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

package com.weavrbank.DeleteGoalField.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.weavrbank.DeleteGoalField.model.ResponseErrorEntryItem;
import java.util.ArrayList;
import java.util.List;
/**
 * ResponseErrors
 */

public class ResponseErrors {
  @JsonProperty("error")
  private List<ResponseErrorEntryItem> error = new ArrayList<>();

  public ResponseErrors error(List<ResponseErrorEntryItem> error) {
    this.error = error;
    return this;
  }

  public ResponseErrors addErrorItem(ResponseErrorEntryItem errorItem) {
    this.error.add(errorItem);
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  public List<ResponseErrorEntryItem> getError() {
    return error;
  }

  public void setError(List<ResponseErrorEntryItem> error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseErrors Response_errors = (ResponseErrors) o;
    return Objects.equals(this.error, Response_errors.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseErrors {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
