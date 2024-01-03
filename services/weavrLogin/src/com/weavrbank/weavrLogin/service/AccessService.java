package com.weavrbank.weavrLogin.service;


import com.weavrbank.weavrLogin.model.*;
import com.weavrbank.weavrLogin.model.ChannelVerifyBody1;
import com.weavrbank.weavrLogin.model.InlineResponse2002;
import com.weavrbank.weavrLogin.model.LoginWithPasswordBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface AccessService {

  /**
   * Login with password
   * Authenticate a user with the &#x60;email&#x60; and &#x60;password&#x60; that they provided when registering.  Given that the user credentials are correct, this returns a &#x60;token&#x60; that can then be used to authorise other secured operations. In case the password is expired, a temporary &#x60;token&#x60; is returned, which can be used solely for updating the password.  The token returned is valid for 5 minutes from last activity. 
    * @param body  (required)
   * @return InlineResponse2002
   */
  @RequestLine("POST /login_with_password")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  InlineResponse2002 loginWithPassword(LoginWithPasswordBody body);

  /**
   * Logout
   * Logs out the user and terminates the session identified by the &#x60;auth_token&#x60; in the Authorization Header.
   */
  @RequestLine("POST /logout")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void logout();

  /**
   * Acquire a new access token
   * Acquire a &#x60;Bearer&#x60; token granting you access to securely perform delegated access operations on behalf of the given &#x60;identity&#x60;.  The token representing the identity should be included in the &#x60;Authorization&#x60; header of all requests to endpoints representing Delegated Access operations. 
   */
  @RequestLine("POST /access_token")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void requestAccessToken();

  /**
   * Issue a one-time password that can be used to step-up a token
   * Initiates the step-up token process by sending an SMS with an one-time-password to a device belonging to the logged-in user that was previously enrolled through &#x60;/authentication_factors/otp/{channel}&#x60; endpoint.  This process is required for endpoints that require a step-up token to complete the call.  _Note that on the Sandbox Environment, text messages are not sent and the one-time-password is always \\\&quot;123456\\\&quot;._ 
    * @param channel The unique identifier for the channel. (required)
   */
  @RequestLine("POST /stepup/challenges/otp/{channel}")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void stepupSCAChallenge(@Param("channel") Object channel);

  /**
   * Issue a push notification that can be used to step-up a token
   * Initiates the step-up token process by submitting a push notification to a device belonging to the logged-in user that was previously enrolled through the &#x60;/authentication_factors/push/{channel}&#x60; endpoint.  You should only start this process if the token step-up isn&#x27;t already in flight. 
    * @param channel  (required)
   */
  @RequestLine("POST /stepup/challenges/push/{channel}")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void stepupSCAChallengePush(@Param("channel") Object channel);

  /**
   * Verify a step-up token using a one-time password
   * Completes the verification process for a step up token.  _Note that on the Sandbox Environment, text messages are not sent and the &#x60;verificationCode&#x60; is always \\\&quot;123456\\\&quot;._ 
    * @param body  (required)
    * @param channel The unique identifier for the channel. (required)
   */
  @RequestLine("POST /stepup/challenges/otp/{channel}/verify")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void stepupSCAVerify(ChannelVerifyBody1 body, @Param("channel") Object channel);

  /**
   * Get user identities
   * Retrieves a list of identities available to the holder of the token.
   */
  @RequestLine("GET /identities")
  @Headers({
    "Accept: ",  })
  void userIdentities();

}
