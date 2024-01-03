/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.weavrbank.brightbankdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
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
 * WealthGoals generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`wealth_goals`")
public class WealthGoals implements Serializable {

    private Integer id;
    private String name;
    private Integer goalCategoryId;
    private Double timeToGoal;
    private Integer savingFrequencyId;
    private Date recurringDay;
    private Double recurringDebitAmount;
    private Boolean isAutoDebitEnabled;
    private Timestamp createdOn;
    private String userId;
    private String recuringDebitAccountId;
    private Double amount;
    private Boolean isActive;
    private SavingFrequency savingFrequency;
    private WealthGoalCategory wealthGoalCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`goal_category_id`", nullable = true, scale = 0, precision = 10)
    public Integer getGoalCategoryId() {
        return this.goalCategoryId;
    }

    public void setGoalCategoryId(Integer goalCategoryId) {
        this.goalCategoryId = goalCategoryId;
    }

    @Column(name = "`time_to_goal`", nullable = true, scale = 0, precision = 10)
    public Double getTimeToGoal() {
        return this.timeToGoal;
    }

    public void setTimeToGoal(Double timeToGoal) {
        this.timeToGoal = timeToGoal;
    }

    @Column(name = "`saving_frequency_id`", nullable = true, scale = 0, precision = 10)
    public Integer getSavingFrequencyId() {
        return this.savingFrequencyId;
    }

    public void setSavingFrequencyId(Integer savingFrequencyId) {
        this.savingFrequencyId = savingFrequencyId;
    }

    @Column(name = "`recurring_day`", nullable = true)
    public Date getRecurringDay() {
        return this.recurringDay;
    }

    public void setRecurringDay(Date recurringDay) {
        this.recurringDay = recurringDay;
    }

    @Column(name = "`recurring_debit_amount`", nullable = true, scale = 0, precision = 10)
    public Double getRecurringDebitAmount() {
        return this.recurringDebitAmount;
    }

    public void setRecurringDebitAmount(Double recurringDebitAmount) {
        this.recurringDebitAmount = recurringDebitAmount;
    }

    @Column(name = "`is_auto_debit_enabled`", nullable = true)
    public Boolean getIsAutoDebitEnabled() {
        return this.isAutoDebitEnabled;
    }

    public void setIsAutoDebitEnabled(Boolean isAutoDebitEnabled) {
        this.isAutoDebitEnabled = isAutoDebitEnabled;
    }

    @Column(name = "`created_on`", nullable = true)
    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "`user_id`", nullable = true, length = 255)
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "`recuring_debit_account_id`", nullable = true, length = 255)
    public String getRecuringDebitAccountId() {
        return this.recuringDebitAccountId;
    }

    public void setRecuringDebitAccountId(String recuringDebitAccountId) {
        this.recuringDebitAccountId = recuringDebitAccountId;
    }

    @Column(name = "`amount`", nullable = true, scale = 0, precision = 10)
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "`is_active`", nullable = true)
    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`saving_frequency_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_saving_frequency_TO_wR59oo`"))
    @Fetch(FetchMode.JOIN)
    public SavingFrequency getSavingFrequency() {
        return this.savingFrequency;
    }

    public void setSavingFrequency(SavingFrequency savingFrequency) {
        if(savingFrequency != null) {
            this.savingFrequencyId = savingFrequency.getId();
        }

        this.savingFrequency = savingFrequency;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`goal_category_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_wealth_goal_category_M2WLF`"))
    @Fetch(FetchMode.JOIN)
    public WealthGoalCategory getWealthGoalCategory() {
        return this.wealthGoalCategory;
    }

    public void setWealthGoalCategory(WealthGoalCategory wealthGoalCategory) {
        if(wealthGoalCategory != null) {
            this.goalCategoryId = wealthGoalCategory.getId();
        }

        this.wealthGoalCategory = wealthGoalCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WealthGoals)) return false;
        final WealthGoals wealthGoals = (WealthGoals) o;
        return Objects.equals(getId(), wealthGoals.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
