package com.epidemic.entity;

import lombok.Data;
/*
* 全球各国最近一日数据
*
* */
import java.util.Date;
@Data
public class Global_today {
    Integer id;
    String name;
    Integer today_confirm;
    Integer today_suspect;
    Integer today_heal;
    Integer today_dead;
    Integer today_severe;
    Integer today_storeConfirm;
    Date lastUpdateTime;
}
