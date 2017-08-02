package com.algorithm.batAlgorithm.string;

import java.util.HashMap;

/**
 * Created by wkhua on 16/12/7.
 */
public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        int count = 0;
        HashMap<Character,Integer> resultMap= new HashMap<Character,Integer>();
        for(int i=0;i<lena;i++){
            char tmpa = A.charAt(i);
            if(!resultMap.containsKey(tmpa)){
                resultMap.put(tmpa,1);
                count++;
            }else{
                resultMap.put(tmpa,resultMap.get(tmpa).intValue()+1);
            }
        }

        for(int i=0;i<lenb;i++){
            char tmpb = B.charAt(i);
            if(resultMap.containsKey(tmpb)){
                if(resultMap.get(tmpb).intValue()==0){
                    return false;
                }else{
                    resultMap.put(tmpb,resultMap.get(tmpb).intValue()-1);
                    if(resultMap.get(tmpb).intValue()==0){
                        count--;
                    }
                }
            }else{
                return false;
            }
        }
        if(count==0){
            return true;
        }

        return false;
    }
    public boolean chkTransformOfArr(String A, int lena, String B, int lenb) {

        if(A.length()!=B.length()){
            return false;
        }

        int[] map = new int[256];
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        for(int i = 0;i<charsA.length;i++){
            map[charsA[i]]++;
        }
        for(int i = 0;i<charsB.length;i++){

            if(map[charsB[i]]--<=0){
                return false;
            }
        }
        return true;
    }

}
