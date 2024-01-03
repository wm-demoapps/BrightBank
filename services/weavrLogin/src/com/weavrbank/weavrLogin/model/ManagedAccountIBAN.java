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
import com.weavrbank.weavrLogin.model.ManagedAccountIBANBankAccountDetails;
import java.util.ArrayList;
import java.util.List;
/**
 * ManagedAccountIBAN
 */

public class ManagedAccountIBAN {
  @JsonProperty("bankAccountDetails")
  private List<ManagedAccountIBANBankAccountDetails> bankAccountDetails = new ArrayList<>();

  /**
   * The state of the Managed Account&#x27;s IBAN as follows:   - UNALLOCATED: The Managed Account has never been assigned an IBAN. Use the _managedAccountsIBANUpgrade_ operation to assign an IBAN to a Managed Account.   - PENDING_ALLOCATION: The IBAN is being allocated to the Managed Account.   - ALLOCATED: An IBAN is allocated to the Managed Account. 
   */
  public enum StateEnum {
    UNALLOCATED("UNALLOCATED"),
    PENDING_ALLOCATION("PENDING_ALLOCATION"),
    ALLOCATED("ALLOCATED");

    private String value;

    StateEnum(String value) {
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
    public static StateEnum fromValue(String input) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("state")
  private StateEnum state = null;

  public ManagedAccountIBAN bankAccountDetails(List<ManagedAccountIBANBankAccountDetails> bankAccountDetails) {
    this.bankAccountDetails = bankAccountDetails;
    return this;
  }

  public ManagedAccountIBAN addBankAccountDetailsItem(ManagedAccountIBANBankAccountDetails bankAccountDetailsItem) {
    this.bankAccountDetails.add(bankAccountDetailsItem);
    return this;
  }

   /**
   * A list of bank account details associated with the IBAN. Multiple details can be provided if multiple IBAN providers are supported by your payment model.
   * @return bankAccountDetails
  **/
  public List<ManagedAccountIBANBankAccountDetails> getBankAccountDetails() {
    return bankAccountDetails;
  }

  public void setBankAccountDetails(List<ManagedAccountIBANBankAccountDetails> bankAccountDetails) {
    this.bankAccountDetails = bankAccountDetails;
  }

  public ManagedAccountIBAN state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * The state of the Managed Account&#x27;s IBAN as follows:   - UNALLOCATED: The Managed Account has never been assigned an IBAN. Use the _managedAccountsIBANUpgrade_ operation to assign an IBAN to a Managed Account.   - PENDING_ALLOCATION: The IBAN is being allocated to the Managed Account.   - ALLOCATED: An IBAN is allocated to the Managed Account. 
   * @return state
  **/
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManagedAccountIBAN ManagedAccountIBAN = (ManagedAccountIBAN) o;
    return Objects.equals(this.bankAccountDetails, ManagedAccountIBAN.bankAccountDetails) &&
        Objects.equals(this.state, ManagedAccountIBAN.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankAccountDetails, state);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManagedAccountIBAN {\n");
    
    sb.append("    bankAccountDetails: ").append(toIndentedString(bankAccountDetails)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
