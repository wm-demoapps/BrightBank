package com.weavrbank.UpdateTheme.service;


import com.weavrbank.UpdateTheme.model.*;
import com.weavrbank.UpdateTheme.model.RootRequest;
import com.weavrbank.UpdateTheme.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface UpdateThemeService {

  /**
   * 
   * 
    * @param id  (required)
    * @param body RequestBody (optional)
   * @return RootResponse
   */
  @RequestLine("PUT /BrightBankDBAPIs/services/BrightBankDB/ThemeConfig/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",  })
  RootResponse invoke(@Param("id") String id, RootRequest body);

}
