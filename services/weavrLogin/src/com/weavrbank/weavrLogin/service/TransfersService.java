package com.weavrbank.weavrLogin.service;


import com.weavrbank.weavrLogin.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface TransfersService {

  /**
   * Create a transfer transaction
   * Transfers funds between managed accounts and managed cards belonging to the same corporate or consumer identity.  The Transfer Profile (configured in the Multi Portal) specified determines the behaviour and restrictions of the transaction (for example, fees). 
    * @param idempotency_ref A unique call reference generated by the caller that, taking into consideration the payload as well as the operation itself, helps avoid duplicate operations. Idempotency reference uniqueness is maintained for at least 24 hours. (optional)
   */
  @RequestLine("POST /transfers")
  @Headers({
    "Content-Type: application/json",
    "Accept: ",
    "idempotency-ref: {idempotency_ref}"  })
  void transferCreate(@Param("idempotency_ref") String idempotency_ref);

  /**
   * Get a transfer transaction
   * Retrieve the transfer transaction identified by the &#x60;id&#x60; path parameter.
    * @param id The unique identifier of the Transfer transaction. (required)
   */
  @RequestLine("GET /transfers/{id}")
  @Headers({
    "Accept: ",  })
  void transferGet(@Param("id") String id);

  /**
   * Get all transfer transactions
   * Retrieves all the transfer transactions performed by the logged-in identity.
    * @param offset The offset value for paging, indicating the initial item number to be returned from the data set satisfying the given criteria. Leave out to fetch the first page of results. (optional)
    * @param limit The limit of the results for paging, starting at the offset. Limit is always capped at 100. (optional)
    * @param profileId Filter by the transfer profile. Leave out to fetch all transfer transactions. (optional)
    * @param instrumentId Filter by the source instrument id. (optional)
    * @param state Filter by the transfer transaction state. Leave out to fetch all states. (optional)
    * @param createdFrom Filter for transfer transactions created after &#x60;createdFrom&#x60; timestamp. Timestamp is expressed in Epoch timestamp using millisecond precision. Leave out to fetch all transfers. (optional)
    * @param createdTo Filter for transfer transactions created before &#x60;createdTo&#x60; timestamp. Timestamp is expressed in Epoch timestamp using millisecond precision. Leave out to fetch all transfers. (optional)
    * @param tag Filter by the transfer tag. The exact tag must be provided, as wildcards are not supported. Leave out to fetch all entries. (optional)
   */
  @RequestLine("GET /transfers?offset={offset}&limit={limit}&profileId={profileId}&instrumentId={instrumentId}&state={state}&createdFrom={createdFrom}&createdTo={createdTo}&tag={tag}")
  @Headers({
    "Accept: ",  })
  void transfersGet(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("profileId") Object profileId, @Param("instrumentId") Object instrumentId, @Param("state") List state, @Param("createdFrom") Long createdFrom, @Param("createdTo") Long createdTo, @Param("tag") String tag);


    /**
     * Get all transfer transactions
     * Retrieves all the transfer transactions performed by the logged-in identity.
     * Note, this is equivalent to the other <code>transfersGet</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link TransfersGetQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>offset - The offset value for paging, indicating the initial item number to be returned from the data set satisfying the given criteria. Leave out to fetch the first page of results. (optional)</li>
     *   <li>limit - The limit of the results for paging, starting at the offset. Limit is always capped at 100. (optional)</li>
     *   <li>profileId - Filter by the transfer profile. Leave out to fetch all transfer transactions. (optional)</li>
     *   <li>instrumentId - Filter by the source instrument id. (optional)</li>
     *   <li>state - Filter by the transfer transaction state. Leave out to fetch all states. (optional)</li>
     *   <li>createdFrom - Filter for transfer transactions created after &#x60;createdFrom&#x60; timestamp. Timestamp is expressed in Epoch timestamp using millisecond precision. Leave out to fetch all transfers. (optional)</li>
     *   <li>createdTo - Filter for transfer transactions created before &#x60;createdTo&#x60; timestamp. Timestamp is expressed in Epoch timestamp using millisecond precision. Leave out to fetch all transfers. (optional)</li>
     *   <li>tag - Filter by the transfer tag. The exact tag must be provided, as wildcards are not supported. Leave out to fetch all entries. (optional)</li>
     *   </ul>
     */
    @RequestLine("GET /transfers?offset={offset}&limit={limit}&profileId={profileId}&instrumentId={instrumentId}&state={state}&createdFrom={createdFrom}&createdTo={createdTo}&tag={tag}")
    @Headers({
    "Accept: ",    })
    void transfersGet
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}