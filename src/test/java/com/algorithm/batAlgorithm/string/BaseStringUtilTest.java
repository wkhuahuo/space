package com.wk.batAlgorithm.string;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/12.
 */
public class BaseStringUtilTest {

    @Test
    public void KMPtest(){
        String targetStr = "abcaacbbcabcaacbbcbadaabcabcaacbbcbadaabcacbdacbdcbd";
        String patternStr = "abcaacbbcbadaabcacbd";
        BaseStringUtil baseStringUtil = new BaseStringUtil();
        int pos = baseStringUtil.KMP(targetStr,patternStr,0);
        System.out.println(pos);
    }

   /* @Test
    public void indexArrTest(){
        String patternStr = "ababababca";//0 0 0 1 2 3 4 5 6 0 1
        int[] nextArr = BaseStringUtil.indexArr(patternStr);
        for(int i:nextArr){
            System.out.print(i+" ");
        }
    }*/
    @Test
    public void myIndexArrTest(){
//        String patternStr = "ababababca";//-1 0 0 1 2 3 4 5 6 0
        String patternStr = "abcaacbbcbadaabcacbd";//-1 0 0 0 1 1 0 0 0 0 0 1 0 1 1 2 3 4 0 0
        int[] nextArr = BaseStringUtil.myIndexArr(patternStr);
        for(int i:nextArr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    @Test
    public void myIndexArr2Test(){
//        String patternStr = "ababababca";//-1 0 -1 0 -1 0 -1 0 6 -1
         String patternStr = "abcaacbbcbadaabcacbd";//-1 0 0 -1 1 1 0 0 0 0 -1 1 -1 1 0 0 -1 4 0 0
        int[] nextArr = BaseStringUtil.myIndexArr2(patternStr);
        for(int i:nextArr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    @Test
    public void myIndexArr3Test(){
//        String patternStr = "ababababca";//-1 0 -1 0 -1 0 -1 0 6 -1
        String patternStr = "abcdabd";//

    //     String patternStr = "abcaacbbcbadaabcacbd";//-1 0 0 -1 1 1 0 0 0 0 -1 1 -1 1 0 0 -1 4 0 0
        int[] nextArr = BaseStringUtil.myIndexArr3(patternStr);
        for(int i:nextArr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
