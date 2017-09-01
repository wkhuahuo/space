package com.algorithm.lintCode.run;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;

/**
 * @author wangkai43
 * @create 2017-09-01-12:11
 * @email wangkai43@meituan.com
 */
public class InOneLine {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here

        if(points == null || points.length<1){
            return 0;
        }
        int Amax=0;
        if(points.length <2){
            return points.length;
        }
        for(int j=0;j<points.length-1;j++) {
            HashMap<Double,Integer> maps = new HashMap<>();
            int Tmax=0;
            for (int i = j+1; i < points.length ; i++) {
                double x = points[i].x - points[j].x;
                double y = points[i].y - points[j].y;
                double key;
                if ((x - 0) < 0.0000001) {
                    key = Double.MAX_VALUE;
                } else if ((y - 0) < 0.0000001) {
                    key = 0;
                } else {
                    key = y / x;
                }
                if (maps.containsKey(key)) {
                    maps.put(key, maps.get(key) + 1);
                    Tmax = Tmax > maps.get(key) ? Tmax : maps.get(key);
                }else{
                    maps.put(key,2);
                }
            }
            Amax = Amax>Tmax? Amax: Tmax;
        }
        return Amax;
    }
}
