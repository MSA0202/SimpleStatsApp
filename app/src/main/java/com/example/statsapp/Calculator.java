package com.example.statsapp;
import java.util.*;
public class Calculator {
    public static Double getMean(ArrayList<Double> arr){
        int big = arr.size();
        Double Meantot=0.0;
        for(int i=0; i<big; ++i){
            Meantot = Meantot + arr.get(i);
        }
        return Meantot/big;
    }
    public static Double getVariance(ArrayList<Double> arr){
        Double avg = getMean(arr);
        int big = arr.size();
        Double tot=0.0;
        for(int i=0; i<big; ++i){
            tot = tot+ Math.pow((arr.get(i)-avg),2);
        }
        return tot/big;
    }
    public static Double getStdDev(ArrayList<Double> arr){
        return Math.sqrt(getVariance(arr));
    }
}
