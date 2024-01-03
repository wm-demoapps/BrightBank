package com.weavrbank.weavrFundAccount.service;


import com.weavrbank.weavrFundAccount.model.*;
import com.weavrbank.weavrFundAccount.model.RootRequest;
import com.weavrbank.weavrFundAccount.model.RootResponse;

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
    * @param managed_account_id  (required)
    * @param body RequestBody (optional)
    * @param programme_key programme-key (optional)
   * @return RootResponse
   */
  @RequestLine("POST /api/accounts/{managed_account_id}/deposit")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
    "programme-key: {programme_key}"  })
  RootResponse restServiceVirtualControllerInvoke(@Param("managed_account_id") String managed_account_id, RootRequest body, @Param("programme_key") String programme_key);

}
