package com.epidemic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/*
* 中国每日疫情数据
* */
public class China_daily {
    Integer id;
    Date date;
    Integer today_confirm;
    Integer today_suspect;
    Integer today_heal;
    Integer today_dead;
    Integer today_severe;
    Integer today_storeConfirm;
    Integer today_input;
    Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "China_daily{" +
                "id=" + id +
                ", date=" + date +
                ", today_confirm=" + today_confirm +
                ", today_suspect=" + today_suspect +
                ", today_heal=" + today_heal +
                ", today_dead=" + today_dead +
                ", today_severe=" + today_severe +
                ", today_storeConfirm=" + today_storeConfirm +
                ", today_input=" + today_input +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }

    public Integer getToday_confirm() {
        return today_confirm;
    }

    public void setToday_confirm(Integer today_confirm) {
        this.today_confirm = today_confirm;
    }

    public Integer getToday_suspect() {
        return today_suspect;
    }

    public void setToday_suspect(Integer today_suspect) {
        this.today_suspect = today_suspect;
    }

    public Integer getToday_heal() {
        return today_heal;
    }

    public void setToday_heal(Integer today_heal) {
        this.today_heal = today_heal;
    }

    public Integer getToday_dead() {
        return today_dead;
    }

    public void setToday_dead(Integer today_dead) {
        this.today_dead = today_dead;
    }

    public Integer getToday_severe() {
        return today_severe;
    }

    public void setToday_severe(Integer today_severe) {
        this.today_severe = today_severe;
    }

    public Integer getToday_storeConfirm() {
        return today_storeConfirm;
    }

    public void setToday_storeConfirm(Integer today_storeConfirm) {
        this.today_storeConfirm = today_storeConfirm;
    }

    public Integer getToday_input() {
        return today_input;
    }

    public void setToday_input(Integer today_input) {
        this.today_input = today_input;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
