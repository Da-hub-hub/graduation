package com.epidemic.dao;

import com.epidemic.entity.China_daily;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ChinaDailyMapper {
    @Select("SELECT * FROM CHINA_DAILY_DATA")
    List<China_daily> findAll();
    //根据日期获取中国当日的疫情数据
    @Select("SELECT * FROM CHINA_DAILY_DATA WHERE DATE=#{date}")
    China_daily findByDate(@Param("date") Date date);
    //根据时间段获取中国指定时间段的疫情数据
    @Select("select * from CHINA_DAILY_DATA where date>=#{start} and date<=#{end}")
    List<China_daily> findInDate(@Param("start") Date start,@Param("end") Date end);
    //获取最新的7条数据进行数据预测
    @Select("select * from CHINA_DAILY_DATA order by id desc limit #{n}")
    List<China_daily> findLimit(@Param("n") int n);
}
