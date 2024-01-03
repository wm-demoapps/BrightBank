package com.weavrbank.GetActiveTheme.service;


import com.weavrbank.GetActiveTheme.model.*;
import com.weavrbank.GetActiveTheme.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface GetActiveThemeService {

  /**
   * 
   * 
   * @return RootResponse
   */
  @RequestLine("GET /BrightBankDBAPIs/services/BrightBankDB/ThemeConfig")
  @Headers({
    "Accept: application/json",  })
  RootResponse invoke();

}
