package com.epidemic.service;

import com.epidemic.dao.ChinaDailyPredictedMapper;
import com.epidemic.data.Predicted;
import com.epidemic.entity.China_daily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChinaDailyPredictedService {
    @Autowired
    private ChinaDailyPredictedMapper chinaDailyPredictedMapper;
    public void chinaDailyPredicted(double a1,int Sn,int n){
        China_daily china_daily = Predicted.WeightedMovingAverage1(a1, Sn, n);
        chinaDailyPredictedMapper.dailyPredicted(china_daily.getDate(),china_daily.getToday_confirm(),china_daily.getToday_suspect(),
                china_daily.getToday_heal(),china_daily.getToday_dead(),china_daily.getToday_severe(),china_daily.getToday_storeConfirm(),
                china_daily.getToday_input(),china_daily.getLastUpdateTime());

    }

    public List<China_daily> allChinaDailyPredicted(){
        List<China_daily> china_dailies = chinaDailyPredictedMapper.chinaDailyPredicted();
        return china_dailies;
    }

    public China_daily chinaDailyPredictedOut(double a1,int Sn,int n){
        China_daily china_daily = Predicted.WeightedMovingAverage1(a1, Sn, n);
        return china_daily;
    }
}
