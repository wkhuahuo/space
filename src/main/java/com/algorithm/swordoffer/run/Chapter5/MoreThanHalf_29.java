package com.algorithm.swordoffer.run.Chapter5;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class MoreThanHalf_29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null){
            return -1;
        }
        int result =array[0];
        int index = 1;
        for(int i=1;i<array.length;i++){
            if(result == array[i]){
                index++;
            }else{
                index--;
                if(index==0 && i == array.length-1 ){
                    return 0;
                }
                if(index ==0 ) {
                    result = array[i];
                    index = 1;
                }
            }

        }

        return result;
    }
}
