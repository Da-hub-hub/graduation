package com.epidemic.service;

import com.epidemic.dao.ChinaDailyMapper;
import com.epidemic.entity.China_daily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChinaDailyService {
    @Autowired
    ChinaDailyMapper chinaDaily;
    public List<China_daily> findAll(){
        List<China_daily> all = chinaDaily.findAll();
        return all;
    }

    public  China_daily findByDate(Date date){
        China_daily byDate=chinaDaily.findByDate(date);
        return byDate;
    }

    public List<China_daily> findInDate(Date start,Date end){
        List<China_daily> inDate = chinaDaily.findInDate(start, end);
        return inDate;
    }

    public List<China_daily> findLimit(int n){
        List<China_daily> sample = chinaDaily.findLimit(n);
        return sample;
    }

}
