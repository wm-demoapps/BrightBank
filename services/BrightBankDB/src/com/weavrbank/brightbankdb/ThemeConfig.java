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
 * ThemeConfig generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`theme_config`")
public class ThemeConfig implements Serializable {

    private Integer id;
    private String name;
    private Integer themeId;

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

    @Column(name = "`theme_id`", nullable = true, scale = 0, precision = 10)
    public Integer getThemeId() {
        return this.themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThemeConfig)) return false;
        final ThemeConfig themeConfig = (ThemeConfig) o;
        return Objects.equals(getId(), themeConfig.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
