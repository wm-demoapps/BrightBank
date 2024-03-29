/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.commons.file.manager.ExportedFileManager;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.weavrbank.brightbankdb.GoalFormFields;
import com.weavrbank.brightbankdb.service.GoalFormFieldsService;


/**
 * Controller object for domain model class GoalFormFields.
 * @see GoalFormFields
 */
@RestController("BrightBankDB.GoalFormFieldsController")
@Api(value = "GoalFormFieldsController", description = "Exposes APIs to work with GoalFormFields resource.")
@RequestMapping("/BrightBankDB/GoalFormFields")
public class GoalFormFieldsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoalFormFieldsController.class);

    @Autowired
	@Qualifier("BrightBankDB.GoalFormFieldsService")
	private GoalFormFieldsService goalFormFieldsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new GoalFormFields instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GoalFormFields createGoalFormFields(@RequestBody GoalFormFields goalFormFields) {
		LOGGER.debug("Create GoalFormFields with information: {}" , goalFormFields);

		goalFormFields = goalFormFieldsService.create(goalFormFields);
		LOGGER.debug("Created GoalFormFields with information: {}" , goalFormFields);

	    return goalFormFields;
	}

    @ApiOperation(value = "Returns the GoalFormFields instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GoalFormFields getGoalFormFields(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting GoalFormFields with id: {}" , id);

        GoalFormFields foundGoalFormFields = goalFormFieldsService.getById(id);
        LOGGER.debug("GoalFormFields details with id: {}" , foundGoalFormFields);

        return foundGoalFormFields;
    }

    @ApiOperation(value = "Updates the GoalFormFields instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GoalFormFields editGoalFormFields(@PathVariable("id") Integer id, @RequestBody GoalFormFields goalFormFields) {
        LOGGER.debug("Editing GoalFormFields with id: {}" , goalFormFields.getId());

        goalFormFields.setId(id);
        goalFormFields = goalFormFieldsService.update(goalFormFields);
        LOGGER.debug("GoalFormFields details with id: {}" , goalFormFields);

        return goalFormFields;
    }
    
    @ApiOperation(value = "Partially updates the GoalFormFields instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GoalFormFields patchGoalFormFields(@PathVariable("id") Integer id, @RequestBody @MapTo(GoalFormFields.class) Map<String, Object> goalFormFieldsPatch) {
        LOGGER.debug("Partially updating GoalFormFields with id: {}" , id);

        GoalFormFields goalFormFields = goalFormFieldsService.partialUpdate(id, goalFormFieldsPatch);
        LOGGER.debug("GoalFormFields details after partial update: {}" , goalFormFields);

        return goalFormFields;
    }

    @ApiOperation(value = "Deletes the GoalFormFields instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteGoalFormFields(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting GoalFormFields with id: {}" , id);

        GoalFormFields deletedGoalFormFields = goalFormFieldsService.delete(id);

        return deletedGoalFormFields != null;
    }

    /**
     * @deprecated Use {@link #findGoalFormFields(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of GoalFormFields instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<GoalFormFields> searchGoalFormFieldsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering GoalFormFields list by query filter:{}", (Object) queryFilters);
        return goalFormFieldsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GoalFormFields instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<GoalFormFields> findGoalFormFields(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GoalFormFields list by filter:", query);
        return goalFormFieldsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GoalFormFields instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<GoalFormFields> filterGoalFormFields(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GoalFormFields list by filter", query);
        return goalFormFieldsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportGoalFormFields(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return goalFormFieldsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportGoalFormFieldsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = GoalFormFields.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> goalFormFieldsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of GoalFormFields instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countGoalFormFields( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting GoalFormFields");
		return goalFormFieldsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getGoalFormFieldsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return goalFormFieldsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service GoalFormFieldsService instance
	 */
	protected void setGoalFormFieldsService(GoalFormFieldsService service) {
		this.goalFormFieldsService = service;
	}

}
