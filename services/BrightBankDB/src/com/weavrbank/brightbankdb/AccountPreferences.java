/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AccountPreferences generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`account_preferences`")
public class AccountPreferences implements Serializable {

    private String accountId;
    private Integer spendLimit;
    private Boolean allowOnlineTransactions;

    @Id
    @Column(name = "`account_id`", nullable = false, length = 255)
    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Column(name = "`spend_limit`", nullable = true, scale = 0, precision = 10)
    public Integer getSpendLimit() {
        return this.spendLimit;
    }

    public void setSpendLimit(Integer spendLimit) {
        this.spendLimit = spendLimit;
    }

    @Column(name = "`allow_online_transactions`", nullable = true)
    public Boolean getAllowOnlineTransactions() {
        return this.allowOnlineTransactions;
    }

    public void setAllowOnlineTransactions(Boolean allowOnlineTransactions) {
        this.allowOnlineTransactions = allowOnlineTransactions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountPreferences)) return false;
        final AccountPreferences accountPreferences = (AccountPreferences) o;
        return Objects.equals(getAccountId(), accountPreferences.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId());
    }
}
