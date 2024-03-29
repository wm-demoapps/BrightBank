/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;

import com.weavrbank.brightbankdb.AccountPreferences;

/**
 * Service object for domain model class {@link AccountPreferences}.
 */
public interface AccountPreferencesService {

    /**
     * Creates a new AccountPreferences. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AccountPreferences if any.
     *
     * @param accountPreferences Details of the AccountPreferences to be created; value cannot be null.
     * @return The newly created AccountPreferences.
     */
    AccountPreferences create(@Valid AccountPreferences accountPreferences);


	/**
     * Returns AccountPreferences by given id if exists.
     *
     * @param accountpreferencesId The id of the AccountPreferences to get; value cannot be null.
     * @return AccountPreferences associated with the given accountpreferencesId.
	 * @throws EntityNotFoundException If no AccountPreferences is found.
     */
    AccountPreferences getById(String accountpreferencesId);

    /**
     * Find and return the AccountPreferences by given id if exists, returns null otherwise.
     *
     * @param accountpreferencesId The id of the AccountPreferences to get; value cannot be null.
     * @return AccountPreferences associated with the given accountpreferencesId.
     */
    AccountPreferences findById(String accountpreferencesId);

	/**
     * Find and return the list of AccountPreferences by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param accountpreferencesIds The id's of the AccountPreferences to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return AccountPreferences associated with the given accountpreferencesIds.
     */
    List<AccountPreferences> findByMultipleIds(List<String> accountpreferencesIds, boolean orderedReturn);


    /**
     * Updates the details of an existing AccountPreferences. It replaces all fields of the existing AccountPreferences with the given accountPreferences.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AccountPreferences if any.
     *
     * @param accountPreferences The details of the AccountPreferences to be updated; value cannot be null.
     * @return The updated AccountPreferences.
     * @throws EntityNotFoundException if no AccountPreferences is found with given input.
     */
    AccountPreferences update(@Valid AccountPreferences accountPreferences);


    /**
     * Partially updates the details of an existing AccountPreferences. It updates only the
     * fields of the existing AccountPreferences which are passed in the accountPreferencesPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AccountPreferences if any.
     *
     * @param accountpreferencesId The id of the AccountPreferences to be deleted; value cannot be null.
     * @param accountPreferencesPatch The partial data of AccountPreferences which is supposed to be updated; value cannot be null.
     * @return The updated AccountPreferences.
     * @throws EntityNotFoundException if no AccountPreferences is found with given input.
     */
    AccountPreferences partialUpdate(String accountpreferencesId, Map<String, Object> accountPreferencesPatch);

    /**
     * Deletes an existing AccountPreferences with the given id.
     *
     * @param accountpreferencesId The id of the AccountPreferences to be deleted; value cannot be null.
     * @return The deleted AccountPreferences.
     * @throws EntityNotFoundException if no AccountPreferences found with the given id.
     */
    AccountPreferences delete(String accountpreferencesId);

    /**
     * Deletes an existing AccountPreferences with the given object.
     *
     * @param accountPreferences The instance of the AccountPreferences to be deleted; value cannot be null.
     */
    void delete(AccountPreferences accountPreferences);

    /**
     * Find all AccountPreferences matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AccountPreferences.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<AccountPreferences> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all AccountPreferences matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AccountPreferences.
     *
     * @see Pageable
     * @see Page
     */
    Page<AccountPreferences> findAll(String query, Pageable pageable);

    /**
     * Exports all AccountPreferences matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all AccountPreferences matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the AccountPreferences in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the AccountPreferences.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}
