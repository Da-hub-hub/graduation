package com.epidemic.entity;

import lombok.Data;
/*
* 各省今日和总体数据
* */
@Data
public class Province {

    Integer id;
    String province;
    Integer total_confirm;
    Integer total_suspect;
    Integer total_heal;
    Integer total_dead;
    Integer today_confirm;
    Integer today_suspect;
    Integer today_heal;
    Integer today_dead;
}
