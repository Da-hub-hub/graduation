package com.epidemic.entity;

import lombok.Data;

import java.util.Date;
/*
* 中国每日总体疫情数据
* */
@Data
public class China_total {
    Integer id;
    Date date;
    Integer total_confirm;
    Integer total_suspect;
    Integer total_heal;
    Integer total_severe;
    Integer total_input;
    Integer total_storeConfirm;
    Integer lastUpdateTime;
}
