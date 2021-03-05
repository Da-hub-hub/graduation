package com.epidemic.data;
import com.epidemic.entity.China_daily;
import com.epidemic.tool.DateUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@DependsOn("dataBreakUp")
public class Predicted implements Serializable {
    private static final long serialVersionUID = 1L;
    static double molecular=0;
    static double  denominator=0;
    static China_daily[] china_dailies;
    //每一个样本值处理结束后，分子，分母置0
    public static void To0(){
        molecular=0;
        denominator=0;
    }

    /*
     *
     *加权移动平均法:
     *Yi——第i期实际值
     *xi——第i期的权数（权数的和等于1）
     *n——本期数
     * */
    public static China_daily WeightedMovingAverage1(double a1,int Sn,int n) {

        China_daily china_daily = new China_daily();
        double result=0;

        //获取指定数量的样本
        Date[] todayDate = DataBreakUp.getTodayDate(n);
        int[] todayConfirm = DataBreakUp.getTodayConfirm(n);
        int[] todaySuspect = DataBreakUp.getTodaySuspect(n);
        int[] todayHeal = DataBreakUp.getTodayHeal(n);
        int[] todayDead = DataBreakUp.getTodayDead(n);
        int[] todaySevere = DataBreakUp.getTodaySevere(n);
        int[] todayStoreConfirm = DataBreakUp.getTodayStoreConfirm(n);
        int[] todayInput = DataBreakUp.getTodayInput(n);
        /*
            根据传入的样本数组获取预测值
        * */
        int confirm = Predict.getPredict(a1, Sn, n, todayConfirm);
        int suspect = Predict.getPredict(a1, Sn, n, todaySuspect);
        int heal = Predict.getPredict(a1, Sn, n, todayHeal);
        int dead = Predict.getPredict(a1, Sn, n, todayDead);
        int severe = Predict.getPredict(a1, Sn, n, todaySevere);
        int storeConfirm = Predict.getPredict(a1, Sn, n, todayStoreConfirm);
        int input = Predict.getPredict(a1, Sn, n, todayInput);

        Date date=todayDate[n-1];
        china_daily.setDate(DateUtil.dateCreateOne(date));
        china_daily.setToday_confirm(confirm);
        china_daily.setToday_suspect(suspect);
        china_daily.setToday_input(input);
        china_daily.setToday_heal(heal);
        china_daily.setToday_dead(dead);
        china_daily.setToday_severe(severe);
        china_daily.setToday_storeConfirm(storeConfirm);
        china_daily.setLastUpdateTime(DateUtil.getNowTime());
        return china_daily;
    }
}


