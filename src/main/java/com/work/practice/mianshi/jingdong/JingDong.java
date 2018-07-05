package com.work.practice.mianshi.jingdong;

import java.math.BigInteger;
import java.util.*;

/**
 * @author wangkai43
 * @create 2017-09-08-20:05
 * @email wangkai43@meituan.com
 */
public class JingDong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a =1;
        int b =1;
        long tmp =0;
        Map<Long,Integer> map = new HashMap<>();
        for(a=1;a<= n;a++) {
            for(b = 1; b<=n; b++){
                tmp = (long) Math.pow(a,b);
                if(map.containsKey(tmp)){
                    map.put(tmp, (map.get(tmp) +1)%1000000007);
                }else {
                    map.put(tmp, 1);
                }
            }
        }
        Set<Long> keys = map.keySet();
        long sum = 0;
        for(Long key: keys){
            sum += getNums(map.get(key));
            sum = sum % 1000000007;
        }
        System.out.println(sum);

    }
    public static long getNums (long key){
        long sum = key;
        for(long i= key;i<= key;i++){
            sum *=i;
            sum = sum % 1000000007;
        }
        return sum;
    }
}
