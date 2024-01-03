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

import com.weavrbank.brightbankdb.Themedetail;

/**
 * Service object for domain model class {@link Themedetail}.
 */
public interface ThemedetailService {

    /**
     * Creates a new Themedetail. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Themedetail if any.
     *
     * @param themedetail Details of the Themedetail to be created; value cannot be null.
     * @return The newly created Themedetail.
     */
    Themedetail create(@Valid Themedetail themedetail);


	/**
     * Returns Themedetail by given id if exists.
     *
     * @param themedetailId The id of the Themedetail to get; value cannot be null.
     * @return Themedetail associated with the given themedetailId.
	 * @throws EntityNotFoundException If no Themedetail is found.
     */
    Themedetail getById(Integer themedetailId);

    /**
     * Find and return the Themedetail by given id if exists, returns null otherwise.
     *
     * @param themedetailId The id of the Themedetail to get; value cannot be null.
     * @return Themedetail associated with the given themedetailId.
     */
    Themedetail findById(Integer themedetailId);

	/**
     * Find and return the list of Themedetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param themedetailIds The id's of the Themedetail to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Themedetails associated with the given themedetailIds.
     */
    List<Themedetail> findByMultipleIds(List<Integer> themedetailIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Themedetail. It replaces all fields of the existing Themedetail with the given themedetail.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Themedetail if any.
     *
     * @param themedetail The details of the Themedetail to be updated; value cannot be null.
     * @return The updated Themedetail.
     * @throws EntityNotFoundException if no Themedetail is found with given input.
     */
    Themedetail update(@Valid Themedetail themedetail);


    /**
     * Partially updates the details of an existing Themedetail. It updates only the
     * fields of the existing Themedetail which are passed in the themedetailPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Themedetail if any.
     *
     * @param themedetailId The id of the Themedetail to be deleted; value cannot be null.
     * @param themedetailPatch The partial data of Themedetail which is supposed to be updated; value cannot be null.
     * @return The updated Themedetail.
     * @throws EntityNotFoundException if no Themedetail is found with given input.
     */
    Themedetail partialUpdate(Integer themedetailId, Map<String, Object> themedetailPatch);

    /**
     * Deletes an existing Themedetail with the given id.
     *
     * @param themedetailId The id of the Themedetail to be deleted; value cannot be null.
     * @return The deleted Themedetail.
     * @throws EntityNotFoundException if no Themedetail found with the given id.
     */
    Themedetail delete(Integer themedetailId);

    /**
     * Deletes an existing Themedetail with the given object.
     *
     * @param themedetail The instance of the Themedetail to be deleted; value cannot be null.
     */
    void delete(Themedetail themedetail);

    /**
     * Find all Themedetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Themedetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Themedetail> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Themedetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Themedetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<Themedetail> findAll(String query, Pageable pageable);

    /**
     * Exports all Themedetails matching the given input query to the given exportType format.
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
     * Exports all Themedetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the Themedetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Themedetail.
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
