package com.epidemic.data;
import com.epidemic.tool.SpringUtil;
import com.epidemic.entity.China_daily;
import com.epidemic.service.ChinaDailyService;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
/*
* 中国每日数据样本采集
* */
@Component
@DependsOn("springUtil")
public class DataBreakUp {
    static ChinaDailyService chinaDailyService=SpringUtil.getBean(com.epidemic.service.ChinaDailyService.class);
    //today_confirm采集
    public static int[] getTodayConfirm(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_confirm();
        }
        return a;
    }
    //today_suspect采集
    public static int[] getTodaySuspect(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_suspect();
        }
        return a;
    }
    //today_heal采集
    public static int[] getTodayHeal(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_heal();
        }
        return a;
    }
    //today_dead采集
    public static int[] getTodayDead(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_dead();
        }
        return a;
    }
    //today_severe采集
    public static int[] getTodaySevere(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_severe();
        }
        return a;
    }
    //today_storeConfirm采集
    public static int[] getTodayStoreConfirm(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_storeConfirm();
        }
        return a;
    }
    //today_Input采集
    public static int[] getTodayInput(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        int a[]=new int[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getToday_input();
        }
        return a;
    }
    //today_date采集
    public static Date[] getTodayDate(int n){
        List<China_daily> sample =chinaDailyService.findLimit(n);
        Date a[]=new Date[n];
        int i=n-1;
        for (China_daily china_daily:sample){
            a[i--]=china_daily.getDate();
        }
        return a;
    }






}
