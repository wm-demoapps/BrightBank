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

import com.weavrbank.brightbankdb.WealthGoalCategory;
import com.weavrbank.brightbankdb.WealthGoals;
import com.weavrbank.brightbankdb.service.WealthGoalCategoryService;


/**
 * Controller object for domain model class WealthGoalCategory.
 * @see WealthGoalCategory
 */
@RestController("BrightBankDB.WealthGoalCategoryController")
@Api(value = "WealthGoalCategoryController", description = "Exposes APIs to work with WealthGoalCategory resource.")
@RequestMapping("/BrightBankDB/WealthGoalCategory")
public class WealthGoalCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WealthGoalCategoryController.class);

    @Autowired
	@Qualifier("BrightBankDB.WealthGoalCategoryService")
	private WealthGoalCategoryService wealthGoalCategoryService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new WealthGoalCategory instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public WealthGoalCategory createWealthGoalCategory(@RequestBody WealthGoalCategory wealthGoalCategory) {
		LOGGER.debug("Create WealthGoalCategory with information: {}" , wealthGoalCategory);

		wealthGoalCategory = wealthGoalCategoryService.create(wealthGoalCategory);
		LOGGER.debug("Created WealthGoalCategory with information: {}" , wealthGoalCategory);

	    return wealthGoalCategory;
	}

    @ApiOperation(value = "Returns the WealthGoalCategory instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public WealthGoalCategory getWealthGoalCategory(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting WealthGoalCategory with id: {}" , id);

        WealthGoalCategory foundWealthGoalCategory = wealthGoalCategoryService.getById(id);
        LOGGER.debug("WealthGoalCategory details with id: {}" , foundWealthGoalCategory);

        return foundWealthGoalCategory;
    }

    @ApiOperation(value = "Updates the WealthGoalCategory instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public WealthGoalCategory editWealthGoalCategory(@PathVariable("id") Integer id, @RequestBody WealthGoalCategory wealthGoalCategory) {
        LOGGER.debug("Editing WealthGoalCategory with id: {}" , wealthGoalCategory.getId());

        wealthGoalCategory.setId(id);
        wealthGoalCategory = wealthGoalCategoryService.update(wealthGoalCategory);
        LOGGER.debug("WealthGoalCategory details with id: {}" , wealthGoalCategory);

        return wealthGoalCategory;
    }
    
    @ApiOperation(value = "Partially updates the WealthGoalCategory instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public WealthGoalCategory patchWealthGoalCategory(@PathVariable("id") Integer id, @RequestBody @MapTo(WealthGoalCategory.class) Map<String, Object> wealthGoalCategoryPatch) {
        LOGGER.debug("Partially updating WealthGoalCategory with id: {}" , id);

        WealthGoalCategory wealthGoalCategory = wealthGoalCategoryService.partialUpdate(id, wealthGoalCategoryPatch);
        LOGGER.debug("WealthGoalCategory details after partial update: {}" , wealthGoalCategory);

        return wealthGoalCategory;
    }

    @ApiOperation(value = "Deletes the WealthGoalCategory instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteWealthGoalCategory(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting WealthGoalCategory with id: {}" , id);

        WealthGoalCategory deletedWealthGoalCategory = wealthGoalCategoryService.delete(id);

        return deletedWealthGoalCategory != null;
    }

    @GetMapping(value = "/name/{name}" )
    @ApiOperation(value = "Returns the matching WealthGoalCategory with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public WealthGoalCategory getByName(@PathVariable("name") String name) {
        LOGGER.debug("Getting WealthGoalCategory with uniques key Name");
        return wealthGoalCategoryService.getByName(name);
    }

    /**
     * @deprecated Use {@link #findWealthGoalCategories(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of WealthGoalCategory instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<WealthGoalCategory> searchWealthGoalCategoriesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering WealthGoalCategories list by query filter:{}", (Object) queryFilters);
        return wealthGoalCategoryService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of WealthGoalCategory instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<WealthGoalCategory> findWealthGoalCategories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering WealthGoalCategories list by filter:", query);
        return wealthGoalCategoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of WealthGoalCategory instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<WealthGoalCategory> filterWealthGoalCategories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering WealthGoalCategories list by filter", query);
        return wealthGoalCategoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportWealthGoalCategories(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return wealthGoalCategoryService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportWealthGoalCategoriesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = WealthGoalCategory.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> wealthGoalCategoryService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of WealthGoalCategory instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countWealthGoalCategories( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting WealthGoalCategories");
		return wealthGoalCategoryService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getWealthGoalCategoryAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return wealthGoalCategoryService.getAggregatedValues(aggregationInfo, pageable);
    }

    @GetMapping(value="/{id:.+}/wealthGoalses")
    @ApiOperation(value = "Gets the wealthGoalses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<WealthGoals> findAssociatedWealthGoalses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated wealthGoalses");
        return wealthGoalCategoryService.findAssociatedWealthGoalses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service WealthGoalCategoryService instance
	 */
	protected void setWealthGoalCategoryService(WealthGoalCategoryService service) {
		this.wealthGoalCategoryService = service;
	}

}
