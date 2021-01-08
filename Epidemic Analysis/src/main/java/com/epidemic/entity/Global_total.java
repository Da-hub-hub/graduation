package com.epidemic.entity;

import lombok.Data;
/*
*
* 全球各国最近一日总体数据
* */
import java.util.Date;
@Data
public class Global_total {
    Integer id;
    String name;
    Integer total_confirm;
    Integer total_suspect;
    Integer total_heal;
    Integer total_dead;
    Integer total_severe;
    Integer total_input;
    Date lastUpdateTime;
}
