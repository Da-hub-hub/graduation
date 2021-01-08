package com.epidemic.data;

import java.math.BigDecimal;

/*
* 等差计算公差及权值
* a1:第一个样本的权值
* Sn:权值总和（根据样本大小决定权值总和精度--1,10,20？）
* n:样本大小
* */
public class Arithmetic {
    public static Double[] getWeight(double a1,int Sn,int n){
        Double[] result=new Double[n];
        result[0]=a1;
        double d=((Sn-n*a1)*2)/(n*(n-1));
        //使用BigDecimal 对double进行格式化，并返回一个值
        BigDecimal b = new BigDecimal(d);
        /*setScale 第一个参数为保留位数 第二个参数为舍入机制
         BigDecimal.ROUND_DOWN 表示不进位
         BigDecimal.ROUND_UP表示进位*/
        double d2 = b.setScale(3, BigDecimal.ROUND_DOWN).doubleValue(); //公差
        for (int i=1;i<n;i++){
            double j;
            j=result[i-1]+d2;
            BigDecimal j1 = new BigDecimal(j);
            double j2 = j1.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
            result[i]=j2;

        }
        return result;

    }

    public static void main(String[] args) {
        Double[] doubles;
        doubles= Arithmetic.getWeight(0.2, 10, 30);
        double j=0;
        for (double i: doubles) {
            j=j+i;
            System.out.println(i);
        }
        System.out.println(j);
    }
}
