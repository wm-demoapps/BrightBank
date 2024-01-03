package com.weavrbank.weavrLogin.service;


import com.weavrbank.weavrLogin.model.*;
import com.weavrbank.weavrLogin.model.ChannelVerifyBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface AdditionalFactorsService {

  /**
   * Get user authentication factors
   * Retrieves the list of authentication factors that can be used to verify the logged-in user.
   */
  @RequestLine("GET /authentication_factors")
  @Headers({
    "Accept: ",  })
  void authFactorsGet();

  /**
   * Enrol a user device for authentication using one-time passwords
   * This is the first step in enrolling the logged-in user&#x27;s mobile device, where a one-time password is sent to the device.  _Note that on the Sandbox Environment, text messages are not sent and the one-time-password is always \\\&quot;123456\\\&quot;._ 
    * @param channel The unique identifier for the channel. (required)
   */
  @RequestLine("POST /authentication_factors/otp/{channel}")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void enrolDeviceUsingOtpStepOne(@Param("channel") Object channel);

  /**
   * Verify enrolment of a user device for authentication using one-time passwords
   * The second step in enrolling the logged-in user (root or authorised user) to use one-time-passwords to enable verification of transactions.  _Note that on the Sandbox Environment, text messages are not sent and the &#x60;verificationCode&#x60; is always set to \\\&quot;123456\\\&quot;._ 
    * @param body  (required)
    * @param channel The unique identifier for the channel. (required)
   */
  @RequestLine("POST /authentication_factors/otp/{channel}/verify")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void enrolDeviceUsingOtpStepTwo(ChannelVerifyBody body, @Param("channel") Object channel);

  /**
   * Enrol a user device for authentication using push notifications
   * This is the first step in enrolling the logged-in user&#x27;s mobile device, where a push notification is sent to the device. 
    * @param channel  (required)
   */
  @RequestLine("POST /authentication_factors/push/{channel}")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",  })
  void enrolDeviceUsingPush(@Param("channel") Object channel);

}
