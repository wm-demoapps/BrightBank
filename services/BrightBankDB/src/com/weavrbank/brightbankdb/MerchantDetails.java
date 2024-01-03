/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MerchantDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`MERCHANT_DETAILS`")
public class MerchantDetails implements Serializable {

    private Integer merchantId;
    private String merchantName;
    private String category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`MERCHANT_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    @Column(name = "`MERCHANT_NAME`", nullable = true, length = 255)
    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Column(name = "`CATEGORY`", nullable = true, length = 255)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MerchantDetails)) return false;
        final MerchantDetails merchantDetails = (MerchantDetails) o;
        return Objects.equals(getMerchantId(), merchantDetails.getMerchantId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMerchantId());
    }
}
