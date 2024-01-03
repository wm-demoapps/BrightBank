package com.weavrbank.weavrLogin.service;


import com.weavrbank.weavrLogin.model.*;
import com.weavrbank.weavrLogin.model.EmailSendBody;
import com.weavrbank.weavrLogin.model.EmailVerifyBody2;
import com.weavrbank.weavrLogin.model.Error;
import com.weavrbank.weavrLogin.model.InlineResponse2004;
import com.weavrbank.weavrLogin.model.InlineResponse4091;
import com.weavrbank.weavrLogin.model.InlineResponse4092;
import com.weavrbank.weavrLogin.model.InlineResponse4093;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface AuthorisedUsersService {

  /**
   * Send an email verification code to the authorised user
   * The first step in verifying an authorised user&#x27;s email. The authorised user whose email address is to be verified is sent an email containing a randomly generated code.  This code must then be provided in the _authorisedUserEmailVerify_ operation to verify the authorised user&#x27;s email address.  _Note that on the Sandbox Environment, the &#x60;verificationCode&#x60; is always set to \\\&quot;123456\\\&quot;._ 
    * @param body  (required)
   */
  @RequestLine("POST /users/verification/email/send")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  void authorisedUserEmailVerificationCodeSend(EmailSendBody body);

  /**
   * Verify email of the authorised user
   * The second step in verifying the authorised user&#x27;s email. The randomly generated code sent to the authorised user via email, using the _authorisedUserEmailVerificationCodeSend_ operation, is submitted here to verify the authorised user&#x27;s email.  This is needed as part of the verification process for basic due diligence.  _Note that on the Sandbox Environment, the &#x60;verificationCode&#x60; is always set to \\\&quot;123456\\\&quot;._ 
    * @param body  (required)
   */
  @RequestLine("POST /users/verification/email/verify")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  void authorisedUserEmailVerify(EmailVerifyBody2 body);

  /**
   * Activate a user
   * Activate the user identified by the &#x60;user_id&#x60; path parameter.  By default, any new users created will be automatically activated. This operation needs to be used only if the user was previously de-activated using the _userDeactivate_ operation, or if the user was de-activated automatically after multiple incorrect login attempts. 
    * @param user_id The user id for which this password is created. (required)
   */
  @RequestLine("POST /users/{user_id}/activate")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userActivate(@Param("user_id") Object user_id);

  /**
   * Create a user
   * Creates a user linked to the logged-in corporate or consumer identity.  Once on-boarded, users have access to all instruments (cards and accounts) of the identity.  Application-specific permissions to limit what each user can view and do need to be implemented in your application. 
   */
  @RequestLine("POST /users")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userCreate();

  /**
   * Deactivate a user
   * De-activate the user identified by the &#x60;user_id&#x60; path parameter.  Deactivated users cannot log in or execute any operations with their credentials.  This operations is not final and a user can be re-activated using the userActivate operation. Note that another active user would need to log in so as to re-activate the de-activated user. 
    * @param user_id The user id for which this password is created. (required)
   */
  @RequestLine("POST /users/{user_id}/deactivate")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userDeactivate(@Param("user_id") Object user_id);

  /**
   * Get a user
   * Retrieves the user identified by the &#x60;user_id&#x60; path parameter.
    * @param user_id The user id for which this password is created. (required)
   */
  @RequestLine("GET /users/{user_id}")
  @Headers({
    "Accept: ",  })
  void userGetById(@Param("user_id") Object user_id);

  /**
   * Consume a user invite
   * Consumes an invitation perviously sent to the user via _userInviteSend_. This is needed so that the invited user sets up the password.  _Note that on the Sandbox Environment, the &#x60;inviteCode&#x60; is always set to \\\&quot;123456\\\&quot;._ 
    * @param user_id The unique identifier for the user. (required)
   */
  @RequestLine("POST /users/{user_id}/invite/consume")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userInviteConsume(@Param("user_id") Object user_id);

  /**
   * Send a user invite
   * Once a user is created using the _userCreate_ operation, the user needs to setup his/her password.  An invitation needs to be sent to the user in order to be able to set up the password for the first time. The invitation email, which remains valid for 1 month, will contain a URL having all information required to setup the password via the _userInviteConsume_. 
    * @param user_id The unique identifier for the user. (required)
   */
  @RequestLine("POST /users/{user_id}/invite")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userInviteSend(@Param("user_id") Object user_id);

  /**
   * Validate a user invite
   * Check if a user&#x27;s invite is still valid. This operation is useful to avoid having the user fill in a form only to be held by a validation issue (eg. expired invite).
    * @param user_id The unique identifier for the user. (required)
   */
  @RequestLine("POST /users/{user_id}/invite/validate")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userInviteValidate(@Param("user_id") Object user_id);

  /**
   * Start KYC for the user
   * Perform the kyc for a corporate user. 
   * @return InlineResponse2004
   */
  @RequestLine("POST /users/kyc")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  InlineResponse2004 userKyc();

  /**
   * Update a user
   * Update the details of a user identified by the &#x60;user_id&#x60; in the the path parameter.  Only the fields that are specified in the request body will be updated. All other fields will remain unchanged. 
    * @param user_id The user id for which this password is created. (required)
   */
  @RequestLine("PATCH /users/{user_id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void userUpdate(@Param("user_id") Object user_id);

  /**
   * Get all users
   * Fetches all authorised users associated with the corporate or consumer identity the logged-in user belongs to.
    * @param offset The offset value for paging, indicating the initial item number to be returned from the data set satisfying the given criteria. Leave out to fetch the first page of results. (optional)
    * @param limit The limit of the results for paging, starting at the offset. Limit is always capped at 100. (optional)
    * @param active Filter for active or deactivated users. Leave out to fetch all users. (optional)
    * @param email Filter by the email address of the user. (optional)
   */
  @RequestLine("GET /users?offset={offset}&limit={limit}&active={active}&email={email}")
  @Headers({
    "Accept: ",  })
  void usersGet(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("active") Boolean active, @Param("email") Object email);


    /**
     * Get all users
     * Fetches all authorised users associated with the corporate or consumer identity the logged-in user belongs to.
     * Note, this is equivalent to the other <code>usersGet</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link UsersGetQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>offset - The offset value for paging, indicating the initial item number to be returned from the data set satisfying the given criteria. Leave out to fetch the first page of results. (optional)</li>
     *   <li>limit - The limit of the results for paging, starting at the offset. Limit is always capped at 100. (optional)</li>
     *   <li>active - Filter for active or deactivated users. Leave out to fetch all users. (optional)</li>
     *   <li>email - Filter by the email address of the user. (optional)</li>
     *   </ul>
     */
    @RequestLine("GET /users?offset={offset}&limit={limit}&active={active}&email={email}")
    @Headers({
    "Accept: ",    })
    void usersGet
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
