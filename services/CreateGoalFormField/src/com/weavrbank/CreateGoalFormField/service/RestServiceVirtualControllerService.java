package com.weavrbank.CreateGoalFormField.service;


import com.weavrbank.CreateGoalFormField.model.*;
import com.weavrbank.CreateGoalFormField.model.RootRequest;
import com.weavrbank.CreateGoalFormField.model.RootResponse;

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
    * @param body RequestBody (optional)
   * @return RootResponse
   */
  @RequestLine("POST /BrightBankDB/GoalFormFields")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  RootResponse restServiceVirtualControllerInvoke(RootRequest body);

}
