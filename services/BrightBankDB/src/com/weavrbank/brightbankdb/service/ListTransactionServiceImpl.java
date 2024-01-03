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

import com.weavrbank.brightbankdb.ListTransaction;


/**
 * ServiceImpl object for domain model class ListTransaction.
 *
 * @see ListTransaction
 */
@Service("BrightBankDB.ListTransactionService")
@Validated
@EntityService(entityClass = ListTransaction.class, serviceId = "BrightBankDB")
public class ListTransactionServiceImpl implements ListTransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListTransactionServiceImpl.class);


    @Autowired
    @Qualifier("BrightBankDB.ListTransactionDao")
    private WMGenericDao<ListTransaction, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<ListTransaction, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public ListTransaction create(ListTransaction listTransaction) {
        LOGGER.debug("Creating a new ListTransaction with information: {}", listTransaction);

        ListTransaction listTransactionCreated = this.wmGenericDao.create(listTransaction);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(listTransactionCreated);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public ListTransaction getById(Integer listtransactionId) {
        LOGGER.debug("Finding ListTransaction by id: {}", listtransactionId);
        return this.wmGenericDao.findById(listtransactionId);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public ListTransaction findById(Integer listtransactionId) {
        LOGGER.debug("Finding ListTransaction by id: {}", listtransactionId);
        try {
            return this.wmGenericDao.findById(listtransactionId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No ListTransaction found with id: {}", listtransactionId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public List<ListTransaction> findByMultipleIds(List<Integer> listtransactionIds, boolean orderedReturn) {
        LOGGER.debug("Finding ListTransactions by ids: {}", listtransactionIds);

        return this.wmGenericDao.findByMultipleIds(listtransactionIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BrightBankDBTransactionManager")
    @Override
    public ListTransaction update(ListTransaction listTransaction) {
        LOGGER.debug("Updating ListTransaction with information: {}", listTransaction);

        this.wmGenericDao.update(listTransaction);
        this.wmGenericDao.refresh(listTransaction);

        return listTransaction;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public ListTransaction partialUpdate(Integer listtransactionId, Map<String, Object>listTransactionPatch) {
        LOGGER.debug("Partially Updating the ListTransaction with id: {}", listtransactionId);

        ListTransaction listTransaction = getById(listtransactionId);

        try {
            ObjectReader listTransactionReader = this.objectMapper.reader().forType(ListTransaction.class).withValueToUpdate(listTransaction);
            listTransaction = listTransactionReader.readValue(this.objectMapper.writeValueAsString(listTransactionPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", listTransactionPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        listTransaction = update(listTransaction);

        return listTransaction;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public ListTransaction delete(Integer listtransactionId) {
        LOGGER.debug("Deleting ListTransaction with id: {}", listtransactionId);
        ListTransaction deleted = this.wmGenericDao.findById(listtransactionId);
        if (deleted == null) {
            LOGGER.debug("No ListTransaction found with id: {}", listtransactionId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), ListTransaction.class.getSimpleName(), listtransactionId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public void delete(ListTransaction listTransaction) {
        LOGGER.debug("Deleting ListTransaction with {}", listTransaction);
        this.wmGenericDao.delete(listTransaction);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<ListTransaction> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ListTransactions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<ListTransaction> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ListTransactions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service BrightBankDB for table ListTransaction to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service BrightBankDB for table ListTransaction to {} format", options.getExportType());
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



}