/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.wavemaker.commons.InvalidInputException;
import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.annotations.EntityService;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;

import com.weavrbank.brightbankdb.Themedetail;
import com.weavrbank.brightbankdb.Themetype;


/**
 * ServiceImpl object for domain model class Themetype.
 *
 * @see Themetype
 */
@Service("BrightBankDB.ThemetypeService")
@Validated
@EntityService(entityClass = Themetype.class, serviceId = "BrightBankDB")
public class ThemetypeServiceImpl implements ThemetypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThemetypeServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("BrightBankDB.ThemedetailService")
    private ThemedetailService themedetailService;

    @Autowired
    @Qualifier("BrightBankDB.ThemetypeDao")
    private WMGenericDao<Themetype, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Themetype, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public Themetype create(Themetype themetype) {
        LOGGER.debug("Creating a new Themetype with information: {}", themetype);

        Themetype themetypeCreated = this.wmGenericDao.create(themetype);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(themetypeCreated);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Themetype getById(Integer themetypeId) {
        LOGGER.debug("Finding Themetype by id: {}", themetypeId);
        return this.wmGenericDao.findById(themetypeId);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Themetype findById(Integer themetypeId) {
        LOGGER.debug("Finding Themetype by id: {}", themetypeId);
        try {
            return this.wmGenericDao.findById(themetypeId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Themetype found with id: {}", themetypeId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public List<Themetype> findByMultipleIds(List<Integer> themetypeIds, boolean orderedReturn) {
        LOGGER.debug("Finding Themetypes by ids: {}", themetypeIds);

        return this.wmGenericDao.findByMultipleIds(themetypeIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BrightBankDBTransactionManager")
    @Override
    public Themetype update(Themetype themetype) {
        LOGGER.debug("Updating Themetype with information: {}", themetype);

        this.wmGenericDao.update(themetype);
        this.wmGenericDao.refresh(themetype);

        return themetype;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public Themetype partialUpdate(Integer themetypeId, Map<String, Object>themetypePatch) {
        LOGGER.debug("Partially Updating the Themetype with id: {}", themetypeId);

        Themetype themetype = getById(themetypeId);

        try {
            ObjectReader themetypeReader = this.objectMapper.reader().forType(Themetype.class).withValueToUpdate(themetype);
            themetype = themetypeReader.readValue(this.objectMapper.writeValueAsString(themetypePatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", themetypePatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        themetype = update(themetype);

        return themetype;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public Themetype delete(Integer themetypeId) {
        LOGGER.debug("Deleting Themetype with id: {}", themetypeId);
        Themetype deleted = this.wmGenericDao.findById(themetypeId);
        if (deleted == null) {
            LOGGER.debug("No Themetype found with id: {}", themetypeId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Themetype.class.getSimpleName(), themetypeId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public void delete(Themetype themetype) {
        LOGGER.debug("Deleting Themetype with {}", themetype);
        this.wmGenericDao.delete(themetype);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<Themetype> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Themetypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<Themetype> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Themetypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service BrightBankDB for table Themetype to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service BrightBankDB for table Themetype to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<Themedetail> findAssociatedThemedetails(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated themedetails");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("themetype.id = '" + id + "'");

        return themedetailService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ThemedetailService instance
     */
    protected void setThemedetailService(ThemedetailService service) {
        this.themedetailService = service;
    }

}
