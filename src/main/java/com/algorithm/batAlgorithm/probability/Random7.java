package com.algorithm.batAlgorithm.probability;

import java.util.Random;

/**
 * 给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，
 * 请实现等概率随机产生1~7的随机函数。(给定一个可调用的Random5::random()方法,可以等概率地随机产生1～5的随机函数)
 * Created by wkhuahuo on 20/02/17.
 */
public class Random7 {
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }
    public int rand5Test(){
        return rand5()*5+(rand5()-1);
        //   return rand.nextInt(5);
    }
    // 通过rand5实现rand7
    public int randomNumber() {
        int m=rand20();
        m = m%7;
        return m+1;
    }
    private int rand20(){
        int m = 21;
        while(m>20){
            m = (rand5()-1)*5+(rand5()-1);
        }
        return m;
    }


}
