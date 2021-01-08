package com.epidemic.dao;

import com.epidemic.entity.China_daily;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChinaDailyPredictedMapper {
    @Insert("insert into china_daily_data_Predicted (date,today_confirm,today_suspect,today_heal,today_dead,today_severe,today_storeConfirm,today_input,lastUpdateTime) values (#{date},#{today_confirm},#{today_suspect},#{today_heal},#{today_dead},#{today_severe},#{today_storeConfirm},#{today_input},#{lastUpdateTime})")
    public void dailyPredicted(@Param("date")Date date,@Param("today_confirm")int today_confirm,@Param("today_suspect") int today_suspect,
                               @Param("today_heal")int today_heal,@Param("today_dead")int today_dead,@Param("today_severe")int today_severe,
                               @Param("today_storeConfirm")int today_storeConfirm,@Param("today_input")int today_input,@Param("lastUpdateTime")Date lastUpdateTime);
   @Select("select * from china_daily_data_Predicted")
    public List<China_daily> chinaDailyPredicted();

}
