package com.wk.batAlgorithm.dynamicprogramming;


import org.junit.Test;

/**
 * Created by wkhuahuo on 2017/2/26.
 */
public class GetChangeTest {

    @Test
    public void testcoin2(){
        Exchange ex = new Exchange();
        int[] arr = {1,2,4};
        int result = ex.coins2(arr, arr.length, 3);
        System.out.println(result);
    }

    @Test
    public void testcoins(){
        Exchange ex = new Exchange();
        int[] arr = {1,2,4};
        int result = ex.coins(arr, arr.length, 3);
        System.out.println(result);
    }
}
