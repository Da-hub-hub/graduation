package com.epidemic.data;
/*
* 不同字段的预测
* */

public class Predict {
    static double molecular=0;
    static double  denominator=0;
    //每一个样本值处理结束后，分子，分母置0
    public static void To0(){
        molecular=0;
        denominator=0;
    }
    //获取权值（a1:第一个样本的权值   Sn：权值总和   n：样本数量）
    public static Double[] getWeight(double a1,int Sn,int n){
        return Arithmetic.getWeight(a1, Sn, n);
    }
    public static int getPredict(double a1,int Sn,int n,int[] data){
        Double[] weight = Predict.getWeight(a1, Sn, n);
        for (int i=0;i<n;i++){
            molecular=weight[i]*data[i]+molecular;
            denominator=weight[i]+denominator;
        }
        int goal= (int) (molecular/denominator);
        Predict.To0();
        return goal;
    }

}
