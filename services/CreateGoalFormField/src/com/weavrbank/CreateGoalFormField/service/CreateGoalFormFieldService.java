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

public interface CreateGoalFormFieldService {

  /**
   * 
   * 
    * @param body RequestBody (optional)
   * @return RootResponse
   */
  @RequestLine("POST /BrightBankDBAPIs/services/BrightBankDB/GoalFormFields")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  RootResponse invoke(RootRequest body);

}
