package com.weavrbank.wvrCardPurchaseAtMerchant.service;


import com.weavrbank.wvrCardPurchaseAtMerchant.model.*;
import com.weavrbank.wvrCardPurchaseAtMerchant.model.RootRequest;
import com.weavrbank.wvrCardPurchaseAtMerchant.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface WvrCardPurchaseAtMerchantService {

  /**
   * 
   * 
    * @param cardId  (required)
    * @param body RequestBody (optional)
    * @param Content_Type Content-Type (optional)
    * @param programme_key programme-key (optional)
   * @return RootResponse
   */
  @RequestLine("POST /api/cards/{cardId}/purchase")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
    "Content-Type: {Content_Type}",

    "programme-key: {programme_key}"  })
  RootResponse invoke(@Param("cardId") String cardId, RootRequest body, @Param("Content_Type") String Content_Type, @Param("programme_key") String programme_key);

}
