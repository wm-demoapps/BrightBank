package com.weavrbank.DeleteGoalField.service;


import com.weavrbank.DeleteGoalField.model.*;
import com.weavrbank.DeleteGoalField.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface DeleteGoalFieldService {

  /**
   * 
   * 
    * @param goal_id  (required)
   * @return RootResponse
   */
  @RequestLine("DELETE /BrightBankDBAPIs/services/BrightBankDB/GoalFormFields/{goal_id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  RootResponse invoke(@Param("goal_id") String goal_id);

}
