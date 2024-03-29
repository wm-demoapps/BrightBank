/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * GoalTransactions generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`goal_transactions`")
public class GoalTransactions implements Serializable {

    private Integer id;
    private Integer goalId;
    private Timestamp paidOn;
    private String debitedAccountId;
    private Double amount;
    private WealthGoals wealthGoals;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`goal_id`", nullable = true, scale = 0, precision = 10)
    public Integer getGoalId() {
        return this.goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    @Column(name = "`paid_on`", nullable = true)
    public Timestamp getPaidOn() {
        return this.paidOn;
    }

    public void setPaidOn(Timestamp paidOn) {
        this.paidOn = paidOn;
    }

    @Column(name = "`debited_account_id`", nullable = true, length = 255)
    public String getDebitedAccountId() {
        return this.debitedAccountId;
    }

    public void setDebitedAccountId(String debitedAccountId) {
        this.debitedAccountId = debitedAccountId;
    }

    @Column(name = "`amount`", nullable = true, scale = 0, precision = 10)
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`goal_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_wealth_goals_TO_goal_UISCH`"))
    @Fetch(FetchMode.JOIN)
    public WealthGoals getWealthGoals() {
        return this.wealthGoals;
    }

    public void setWealthGoals(WealthGoals wealthGoals) {
        if(wealthGoals != null) {
            this.goalId = wealthGoals.getId();
        }

        this.wealthGoals = wealthGoals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoalTransactions)) return false;
        final GoalTransactions goalTransactions = (GoalTransactions) o;
        return Objects.equals(getId(), goalTransactions.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
