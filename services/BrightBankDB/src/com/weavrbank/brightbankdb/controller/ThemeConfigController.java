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

import com.weavrbank.brightbankdb.ThemeConfig;
import com.weavrbank.brightbankdb.service.ThemeConfigService;


/**
 * Controller object for domain model class ThemeConfig.
 * @see ThemeConfig
 */
@RestController("BrightBankDB.ThemeConfigController")
@Api(value = "ThemeConfigController", description = "Exposes APIs to work with ThemeConfig resource.")
@RequestMapping("/BrightBankDB/ThemeConfig")
public class ThemeConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThemeConfigController.class);

    @Autowired
	@Qualifier("BrightBankDB.ThemeConfigService")
	private ThemeConfigService themeConfigService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ThemeConfig instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ThemeConfig createThemeConfig(@RequestBody ThemeConfig themeConfig) {
		LOGGER.debug("Create ThemeConfig with information: {}" , themeConfig);

		themeConfig = themeConfigService.create(themeConfig);
		LOGGER.debug("Created ThemeConfig with information: {}" , themeConfig);

	    return themeConfig;
	}

    @ApiOperation(value = "Returns the ThemeConfig instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ThemeConfig getThemeConfig(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ThemeConfig with id: {}" , id);

        ThemeConfig foundThemeConfig = themeConfigService.getById(id);
        LOGGER.debug("ThemeConfig details with id: {}" , foundThemeConfig);

        return foundThemeConfig;
    }

    @ApiOperation(value = "Updates the ThemeConfig instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ThemeConfig editThemeConfig(@PathVariable("id") Integer id, @RequestBody ThemeConfig themeConfig) {
        LOGGER.debug("Editing ThemeConfig with id: {}" , themeConfig.getId());

        themeConfig.setId(id);
        themeConfig = themeConfigService.update(themeConfig);
        LOGGER.debug("ThemeConfig details with id: {}" , themeConfig);

        return themeConfig;
    }
    
    @ApiOperation(value = "Partially updates the ThemeConfig instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ThemeConfig patchThemeConfig(@PathVariable("id") Integer id, @RequestBody @MapTo(ThemeConfig.class) Map<String, Object> themeConfigPatch) {
        LOGGER.debug("Partially updating ThemeConfig with id: {}" , id);

        ThemeConfig themeConfig = themeConfigService.partialUpdate(id, themeConfigPatch);
        LOGGER.debug("ThemeConfig details after partial update: {}" , themeConfig);

        return themeConfig;
    }

    @ApiOperation(value = "Deletes the ThemeConfig instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteThemeConfig(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ThemeConfig with id: {}" , id);

        ThemeConfig deletedThemeConfig = themeConfigService.delete(id);

        return deletedThemeConfig != null;
    }

    /**
     * @deprecated Use {@link #findThemeConfigs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ThemeConfig instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ThemeConfig> searchThemeConfigsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ThemeConfigs list by query filter:{}", (Object) queryFilters);
        return themeConfigService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ThemeConfig instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ThemeConfig> findThemeConfigs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ThemeConfigs list by filter:", query);
        return themeConfigService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ThemeConfig instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ThemeConfig> filterThemeConfigs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ThemeConfigs list by filter", query);
        return themeConfigService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportThemeConfigs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return themeConfigService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportThemeConfigsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ThemeConfig.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> themeConfigService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ThemeConfig instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countThemeConfigs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ThemeConfigs");
		return themeConfigService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getThemeConfigAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return themeConfigService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ThemeConfigService instance
	 */
	protected void setThemeConfigService(ThemeConfigService service) {
		this.themeConfigService = service;
	}

}
