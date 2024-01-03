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

import com.weavrbank.brightbankdb.MerchantDetails;


/**
 * ServiceImpl object for domain model class MerchantDetails.
 *
 * @see MerchantDetails
 */
@Service("BrightBankDB.MerchantDetailsService")
@Validated
@EntityService(entityClass = MerchantDetails.class, serviceId = "BrightBankDB")
public class MerchantDetailsServiceImpl implements MerchantDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantDetailsServiceImpl.class);


    @Autowired
    @Qualifier("BrightBankDB.MerchantDetailsDao")
    private WMGenericDao<MerchantDetails, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<MerchantDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public MerchantDetails create(MerchantDetails merchantDetails) {
        LOGGER.debug("Creating a new MerchantDetails with information: {}", merchantDetails);

        MerchantDetails merchantDetailsCreated = this.wmGenericDao.create(merchantDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(merchantDetailsCreated);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public MerchantDetails getById(Integer merchantdetailsId) {
        LOGGER.debug("Finding MerchantDetails by id: {}", merchantdetailsId);
        return this.wmGenericDao.findById(merchantdetailsId);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public MerchantDetails findById(Integer merchantdetailsId) {
        LOGGER.debug("Finding MerchantDetails by id: {}", merchantdetailsId);
        try {
            return this.wmGenericDao.findById(merchantdetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No MerchantDetails found with id: {}", merchantdetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public List<MerchantDetails> findByMultipleIds(List<Integer> merchantdetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding MerchantDetails by ids: {}", merchantdetailsIds);

        return this.wmGenericDao.findByMultipleIds(merchantdetailsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BrightBankDBTransactionManager")
    @Override
    public MerchantDetails update(MerchantDetails merchantDetails) {
        LOGGER.debug("Updating MerchantDetails with information: {}", merchantDetails);

        this.wmGenericDao.update(merchantDetails);
        this.wmGenericDao.refresh(merchantDetails);

        return merchantDetails;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public MerchantDetails partialUpdate(Integer merchantdetailsId, Map<String, Object>merchantDetailsPatch) {
        LOGGER.debug("Partially Updating the MerchantDetails with id: {}", merchantdetailsId);

        MerchantDetails merchantDetails = getById(merchantdetailsId);

        try {
            ObjectReader merchantDetailsReader = this.objectMapper.reader().forType(MerchantDetails.class).withValueToUpdate(merchantDetails);
            merchantDetails = merchantDetailsReader.readValue(this.objectMapper.writeValueAsString(merchantDetailsPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", merchantDetailsPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        merchantDetails = update(merchantDetails);

        return merchantDetails;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public MerchantDetails delete(Integer merchantdetailsId) {
        LOGGER.debug("Deleting MerchantDetails with id: {}", merchantdetailsId);
        MerchantDetails deleted = this.wmGenericDao.findById(merchantdetailsId);
        if (deleted == null) {
            LOGGER.debug("No MerchantDetails found with id: {}", merchantdetailsId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), MerchantDetails.class.getSimpleName(), merchantdetailsId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "BrightBankDBTransactionManager")
    @Override
    public void delete(MerchantDetails merchantDetails) {
        LOGGER.debug("Deleting MerchantDetails with {}", merchantDetails);
        this.wmGenericDao.delete(merchantDetails);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<MerchantDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all MerchantDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager")
    @Override
    public Page<MerchantDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all MerchantDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service BrightBankDB for table MerchantDetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "BrightBankDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service BrightBankDB for table MerchantDetails to {} format", options.getExportType());
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
