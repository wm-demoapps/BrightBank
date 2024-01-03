package com.weavrbank.weavrVerifyKYC.service;


import com.weavrbank.weavrVerifyKYC.model.*;
import com.weavrbank.weavrVerifyKYC.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface RestServiceVirtualControllerService {

  /**
   * 
   * 
    * @param consumer_id  (required)
    * @param programme_key programme-key (optional)
   * @return RootResponse
   */
  @RequestLine("POST /api/consumers/{consumer_id}/verify")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
    "programme-key: {programme_key}"  })
  RootResponse restServiceVirtualControllerInvoke(@Param("consumer_id") String consumer_id, @Param("programme_key") String programme_key);

}
