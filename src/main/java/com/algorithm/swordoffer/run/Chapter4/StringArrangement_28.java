package com.algorithm.swordoffer.run.Chapter4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class StringArrangement_28 {
    public ArrayList<String> Permutation(String str) {
        if(str == null){
            return null;
        }
        ArrayList<String> arrLists = new ArrayList<>();

        if(str.length() == 0){
            return arrLists;
        }
        if(str.length() == 1){
            arrLists.add(str);
            return arrLists;
        }

        char[] chars = str.toCharArray();
        printStr(chars,0,arrLists);
        Collections.sort(arrLists);
        /*arrLists.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index=0;
                while(index < o1.length() && index < o2.length()){
                    if(o1.charAt(index) > o2.charAt(index)){
                        return 1;
                    }else if(o1.charAt(index) < o2.charAt(index)){
                        return -1;
                    }
                    index++;
                }
                return 0;
            }
        });*/
        return arrLists;
    }
    private  void printStr(char[] chars,int index,ArrayList<String> arrLists){
        if(index>=chars.length){
            return ;
        }
        for(int i=index ;i<chars.length; i++){
            char tmp = chars[index];
            if(chars[index] != chars[i]){
                chars[index] = chars[i];
                chars[i] = tmp;
            }
            String str = new String(chars);
            if(!arrLists.contains(str)) {
                arrLists.add(str);
            }
            printStr(chars,index+1,arrLists);
            tmp = chars[index];
            chars[index] = chars[i];
            chars[i] = tmp;
        }

        return ;
    }



}
