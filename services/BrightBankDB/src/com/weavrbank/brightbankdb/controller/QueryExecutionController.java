/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.commons.file.manager.ExportedFileManager;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.weavrbank.brightbankdb.service.BrightBankDBQueryExecutorService;
import com.weavrbank.brightbankdb.models.query.*;

@RestController(value = "BrightBankDB.QueryExecutionController")
@RequestMapping("/BrightBankDB/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private BrightBankDBQueryExecutorService queryService;

    @Autowired
	private ExportedFileManager exportedFileManager;

    @GetMapping(value = "/queries/qrGoalTransactionSummryByGoal")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "to get summary amount by goal")
    public Page<QrGoalTransactionSummryByGoalResponse> executeQrGoalTransactionSummryByGoal(@RequestParam(value = "goal_id") Integer goalId, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: qrGoalTransactionSummryByGoal");
        Page<QrGoalTransactionSummryByGoalResponse> _result = queryService.executeQrGoalTransactionSummryByGoal(goalId, pageable);
        LOGGER.debug("got the result for named query: qrGoalTransactionSummryByGoal, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file url for query qrGoalTransactionSummryByGoal")
    @PostMapping(value = "/queries/qrGoalTransactionSummryByGoal/export")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportQrGoalTransactionSummryByGoal(@RequestParam(value = "goal_id") Integer goalId, @RequestBody ExportOptions exportOptions, Pageable pageable) {
        LOGGER.debug("Exporting named query: qrGoalTransactionSummryByGoal");

        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = "qrGoalTransactionSummryByGoal";
        }
        exportedFileName += exportOptions.getExportType().getExtension();

        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName,
                        outputStream -> queryService.exportQrGoalTransactionSummryByGoal(goalId,  exportOptions, pageable, outputStream));

        return new StringWrapper(exportedUrl);
    }

    @GetMapping(value = "/queries/qrWealthGoalsList")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "To get lost of gols with time left goal end date")
    public Page<QrWealthGoalsListResponse> executeQrWealthGoalsList(@RequestParam(value = "user_id") String userId, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: qrWealthGoalsList");
        Page<QrWealthGoalsListResponse> _result = queryService.executeQrWealthGoalsList(userId, pageable);
        LOGGER.debug("got the result for named query: qrWealthGoalsList, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file url for query qrWealthGoalsList")
    @PostMapping(value = "/queries/qrWealthGoalsList/export")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportQrWealthGoalsList(@RequestParam(value = "user_id") String userId, @RequestBody ExportOptions exportOptions, Pageable pageable) {
        LOGGER.debug("Exporting named query: qrWealthGoalsList");

        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = "qrWealthGoalsList";
        }
        exportedFileName += exportOptions.getExportType().getExtension();

        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName,
                        outputStream -> queryService.exportQrWealthGoalsList(userId,  exportOptions, pageable, outputStream));

        return new StringWrapper(exportedUrl);
    }

}
