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

package com.weavrbank.getThemeType.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * ResponseContentEntryItem
 */

public class ResponseContentEntryItem {
  @JsonProperty("thumbnail")
  private String thumbnail = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("isdefault")
  private String isdefault = null;

  public ResponseContentEntryItem thumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
    return this;
  }

   /**
   * Get thumbnail
   * @return thumbnail
  **/
  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public ResponseContentEntryItem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResponseContentEntryItem id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ResponseContentEntryItem isdefault(String isdefault) {
    this.isdefault = isdefault;
    return this;
  }

   /**
   * Get isdefault
   * @return isdefault
  **/
  public String getIsdefault() {
    return isdefault;
  }

  public void setIsdefault(String isdefault) {
    this.isdefault = isdefault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseContentEntryItem Response_contentEntryItem = (ResponseContentEntryItem) o;
    return Objects.equals(this.thumbnail, Response_contentEntryItem.thumbnail) &&
        Objects.equals(this.name, Response_contentEntryItem.name) &&
        Objects.equals(this.id, Response_contentEntryItem.id) &&
        Objects.equals(this.isdefault, Response_contentEntryItem.isdefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(thumbnail, name, id, isdefault);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseContentEntryItem {\n");
    
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
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
