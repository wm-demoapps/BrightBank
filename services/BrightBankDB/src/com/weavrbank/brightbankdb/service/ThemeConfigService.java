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

import com.weavrbank.brightbankdb.ThemeConfig;

/**
 * Service object for domain model class {@link ThemeConfig}.
 */
public interface ThemeConfigService {

    /**
     * Creates a new ThemeConfig. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ThemeConfig if any.
     *
     * @param themeConfig Details of the ThemeConfig to be created; value cannot be null.
     * @return The newly created ThemeConfig.
     */
    ThemeConfig create(@Valid ThemeConfig themeConfig);


	/**
     * Returns ThemeConfig by given id if exists.
     *
     * @param themeconfigId The id of the ThemeConfig to get; value cannot be null.
     * @return ThemeConfig associated with the given themeconfigId.
	 * @throws EntityNotFoundException If no ThemeConfig is found.
     */
    ThemeConfig getById(Integer themeconfigId);

    /**
     * Find and return the ThemeConfig by given id if exists, returns null otherwise.
     *
     * @param themeconfigId The id of the ThemeConfig to get; value cannot be null.
     * @return ThemeConfig associated with the given themeconfigId.
     */
    ThemeConfig findById(Integer themeconfigId);

	/**
     * Find and return the list of ThemeConfigs by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param themeconfigIds The id's of the ThemeConfig to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ThemeConfigs associated with the given themeconfigIds.
     */
    List<ThemeConfig> findByMultipleIds(List<Integer> themeconfigIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ThemeConfig. It replaces all fields of the existing ThemeConfig with the given themeConfig.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ThemeConfig if any.
     *
     * @param themeConfig The details of the ThemeConfig to be updated; value cannot be null.
     * @return The updated ThemeConfig.
     * @throws EntityNotFoundException if no ThemeConfig is found with given input.
     */
    ThemeConfig update(@Valid ThemeConfig themeConfig);


    /**
     * Partially updates the details of an existing ThemeConfig. It updates only the
     * fields of the existing ThemeConfig which are passed in the themeConfigPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ThemeConfig if any.
     *
     * @param themeconfigId The id of the ThemeConfig to be deleted; value cannot be null.
     * @param themeConfigPatch The partial data of ThemeConfig which is supposed to be updated; value cannot be null.
     * @return The updated ThemeConfig.
     * @throws EntityNotFoundException if no ThemeConfig is found with given input.
     */
    ThemeConfig partialUpdate(Integer themeconfigId, Map<String, Object> themeConfigPatch);

    /**
     * Deletes an existing ThemeConfig with the given id.
     *
     * @param themeconfigId The id of the ThemeConfig to be deleted; value cannot be null.
     * @return The deleted ThemeConfig.
     * @throws EntityNotFoundException if no ThemeConfig found with the given id.
     */
    ThemeConfig delete(Integer themeconfigId);

    /**
     * Deletes an existing ThemeConfig with the given object.
     *
     * @param themeConfig The instance of the ThemeConfig to be deleted; value cannot be null.
     */
    void delete(ThemeConfig themeConfig);

    /**
     * Find all ThemeConfigs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ThemeConfigs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ThemeConfig> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ThemeConfigs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ThemeConfigs.
     *
     * @see Pageable
     * @see Page
     */
    Page<ThemeConfig> findAll(String query, Pageable pageable);

    /**
     * Exports all ThemeConfigs matching the given input query to the given exportType format.
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
     * Exports all ThemeConfigs matching the given input query to the given exportType format.
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
     * Retrieve the count of the ThemeConfigs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ThemeConfig.
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
