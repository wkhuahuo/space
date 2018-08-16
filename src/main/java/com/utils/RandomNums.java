package com.utils;

/**
 * @author wangkai43
 * @create 2018-08-01-17:49
 * @email wangkai43@meituan.com
 */
public class RandomNums {

    /**
     * 产生一个付出正态分布的随机数
     * @param mean 均值
     * @param std_dev 方差
     * @return
     */
    public double getNumberInNormalDistribution(double mean, double std_dev){
        return mean+(uniform2NormalDistribution(12)*std_dev);
    }

    private double uniform2NormalDistribution(int accuracy){
        double sum=0.0;
        for(int i=0; i<accuracy; i++){
            sum=sum+Math.random();
        }
        return sum-6.0;
    }

    public static void main(String[] args) {
        RandomNums randomNums = new RandomNums();
        int nums = 1000;
        while(nums-->0){
            double result = randomNums.getNumberInNormalDistribution(10, 2);
            System.out.println(result);
        }
    }
}
