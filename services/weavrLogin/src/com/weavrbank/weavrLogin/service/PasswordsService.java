package com.weavrbank.weavrLogin.service;


import com.weavrbank.weavrLogin.model.*;
import com.weavrbank.weavrLogin.model.InlineResponse2003;
import com.weavrbank.weavrLogin.model.UserIdCreateBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface PasswordsService {

  /**
   * Initiate lost password process
   * Initiate the lost password process.  If the email address provided is associated with an active user, an email will be sent, containing a URL that redirects the user to change their password. The URL contains request parameters for all of the parameters required to change the password for the user via the &#x60;/passwords/lost_password/resume&#x60; POST endpoint. 
   */
  @RequestLine("POST /passwords/lost_password/start")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void lostPasswordInitiate();

  /**
   * Resume lost password process
   * This is the second and final step in updating the password of a user who forgot their password.
   */
  @RequestLine("POST /passwords/lost_password/resume")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void lostPasswordResume();

  /**
   * Create a password
   * Create a new password for the user identified by the &#x60;user_id&#x60; path parameter.
    * @param body  (required)
    * @param user_id The user id for which this password is created. (required)
   * @return InlineResponse2003
   */
  @RequestLine("POST /passwords/{user_id}/create")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  InlineResponse2003 passwordCreate(UserIdCreateBody body, @Param("user_id") Object user_id);

  /**
   * Update a password
   * Update the password for the logged-in user.
   */
  @RequestLine("POST /passwords/update")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void passwordUpdate();

  /**
   * Validate a password
   * Check that a password adheres to all complexity checks.
   */
  @RequestLine("POST /passwords/validate")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void passwordValidate();

}
