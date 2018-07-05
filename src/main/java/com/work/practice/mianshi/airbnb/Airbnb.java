package com.work.practice.mianshi.airbnb;

import java.util.ArrayList;

/**
 * @author wangkai43
 * @create 2017-09-28-20:14
 * @email wangkai43@meituan.com
 */
public class Airbnb {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        socialGraphs(nums);
    }
    static void socialGraphs(int[] counts) {
        int length = counts.length;
        int count=0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            if(counts[i] == -1) continue;

            int val = counts[i];
            int tmpCount = counts[i];
            counts[i] = -1;

            list.add(i);
            tmpCount--;
            while(tmpCount>0){
                for(int j=i+1;j<length;j++){
                    if(counts[j] == val ){
                        tmpCount--;
                        list.add(j);
                        counts[j] = -1;
                    }

                    if(tmpCount ==0) break;

                }
            }
            StringBuffer strb = new StringBuffer();
            for(int k=0;k<list.size()-1;k++){
                strb.append(list.get(k)+" ");
            }
            strb.append(list.get(list.size()-1));
            System.out.println(strb.toString());
            list.clear();
        }


    }
}
