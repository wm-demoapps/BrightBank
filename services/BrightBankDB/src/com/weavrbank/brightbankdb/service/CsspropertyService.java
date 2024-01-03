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

import com.weavrbank.brightbankdb.Cssproperty;
import com.weavrbank.brightbankdb.Themedetail;

/**
 * Service object for domain model class {@link Cssproperty}.
 */
public interface CsspropertyService {

    /**
     * Creates a new Cssproperty. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Cssproperty if any.
     *
     * @param cssproperty Details of the Cssproperty to be created; value cannot be null.
     * @return The newly created Cssproperty.
     */
    Cssproperty create(@Valid Cssproperty cssproperty);


	/**
     * Returns Cssproperty by given id if exists.
     *
     * @param csspropertyId The id of the Cssproperty to get; value cannot be null.
     * @return Cssproperty associated with the given csspropertyId.
	 * @throws EntityNotFoundException If no Cssproperty is found.
     */
    Cssproperty getById(Integer csspropertyId);

    /**
     * Find and return the Cssproperty by given id if exists, returns null otherwise.
     *
     * @param csspropertyId The id of the Cssproperty to get; value cannot be null.
     * @return Cssproperty associated with the given csspropertyId.
     */
    Cssproperty findById(Integer csspropertyId);

	/**
     * Find and return the list of Cssproperties by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param csspropertyIds The id's of the Cssproperty to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Cssproperties associated with the given csspropertyIds.
     */
    List<Cssproperty> findByMultipleIds(List<Integer> csspropertyIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Cssproperty. It replaces all fields of the existing Cssproperty with the given cssproperty.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Cssproperty if any.
     *
     * @param cssproperty The details of the Cssproperty to be updated; value cannot be null.
     * @return The updated Cssproperty.
     * @throws EntityNotFoundException if no Cssproperty is found with given input.
     */
    Cssproperty update(@Valid Cssproperty cssproperty);


    /**
     * Partially updates the details of an existing Cssproperty. It updates only the
     * fields of the existing Cssproperty which are passed in the csspropertyPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Cssproperty if any.
     *
     * @param csspropertyId The id of the Cssproperty to be deleted; value cannot be null.
     * @param csspropertyPatch The partial data of Cssproperty which is supposed to be updated; value cannot be null.
     * @return The updated Cssproperty.
     * @throws EntityNotFoundException if no Cssproperty is found with given input.
     */
    Cssproperty partialUpdate(Integer csspropertyId, Map<String, Object> csspropertyPatch);

    /**
     * Deletes an existing Cssproperty with the given id.
     *
     * @param csspropertyId The id of the Cssproperty to be deleted; value cannot be null.
     * @return The deleted Cssproperty.
     * @throws EntityNotFoundException if no Cssproperty found with the given id.
     */
    Cssproperty delete(Integer csspropertyId);

    /**
     * Deletes an existing Cssproperty with the given object.
     *
     * @param cssproperty The instance of the Cssproperty to be deleted; value cannot be null.
     */
    void delete(Cssproperty cssproperty);

    /**
     * Find all Cssproperties matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Cssproperties.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Cssproperty> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Cssproperties matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Cssproperties.
     *
     * @see Pageable
     * @see Page
     */
    Page<Cssproperty> findAll(String query, Pageable pageable);

    /**
     * Exports all Cssproperties matching the given input query to the given exportType format.
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
     * Exports all Cssproperties matching the given input query to the given exportType format.
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
     * Retrieve the count of the Cssproperties in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Cssproperty.
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

    /*
     * Returns the associated themedetails for given Cssproperty id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Themedetail instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Themedetail> findAssociatedThemedetails(Integer id, Pageable pageable);

}
