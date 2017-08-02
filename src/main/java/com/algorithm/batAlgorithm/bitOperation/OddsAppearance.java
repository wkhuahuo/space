package com.algorithm.batAlgorithm.bitOperation;

/**
 * Created by wkhuahuo on 17/02/17.
 */
public class OddsAppearance {
    public int[] findOdds(int[] arr, int n) {
        int[] tmp = new int[2];
        int num=arr[0];
        for(int i=1;i<arr.length;i++){
            num ^=arr[i];
        }
        int index=1;
        while((num & index )==0){
            index <<=1;
        }
        int num2 = num;
        for(int i=0;i<arr.length;i++){
            if((arr[i] & index)!=0){
                num ^=arr[i];
            }
        }
        num2 = num^num2;
        if(num>num2){
            tmp[0] = num2;
            tmp[1] = num;
        }else {
            tmp[0] = num;
            tmp[1] = num2;
        }
        return tmp;
    }
}
