package com.weavrbank.GoalFormFields.service;


import com.weavrbank.GoalFormFields.model.*;
import com.weavrbank.GoalFormFields.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface GoalFormFieldsService {

  /**
   * 
   * 
   * @return RootResponse
   */
  @RequestLine("GET /BrightBankDBAPIs/services/BrightBankDB/GoalFormFields")
  @Headers({
    "Accept: application/json",  })
  RootResponse invoke();

}
