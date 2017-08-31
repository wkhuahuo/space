package com.work.practice.mianshi.huawei;

import java.util.*;

/**
 * @author wangkai43
 * @create 2017-08-16-19:50
 * @email wangkai43@meituan.com
 */
public class HW2Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> nums = new ArrayList<>();
        while(in.hasNext()) {
            String str = in.next();
            nums.add(str);
            if(str.charAt(str.length()-1) == '}'){
                break;
            }
        }
        Map<String,String> nodes = new HashMap<>();

        int[][] maps = new int[0xffff][0xffff];
        for(String tmp : nums){
            tmp = tmp.substring(1,tmp.length()-1);
            String[] childs = tmp.split(",");
            for(int i=0;i<childs.length;i++){
                childs[i] = childs[i].trim();
                int a = Integer.valueOf(childs[0]);
                int b = Integer.valueOf(childs[1]);
                maps[a][b] = 1;//初始记录关系
            }
        }

        for(int i=0;i<0xffff;){
            for(int j=0;j<0xffff;j++){
                if(maps[i][j] == 1){
                    if(i == j){
                        maps[i][i] = 2;
                        break;
                    }
                    i = j;
                    break;
                }
            }
        }
        for(int i=0;i<0xffff;i++){
            if(maps[i][i] == 2){
                System.out.println(maps[i][i]+", "+"true}");
            }else{
                System.out.println(maps[i][i]+", "+"false}");
            }
        }


    }


}
