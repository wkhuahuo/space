package com.algorithm.lintCode.run;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2017-08-30-14:49
 * @email wangkai43@meituan.com
 */
public class LRUCache1  {


    private final int capacity;
    private LinkedHashMap<Integer,Integer> map = null;
    // @param capacity, an integer
    public LRUCache1(final int capacity) {

        this.capacity = capacity;
       this.map =  new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > capacity;
            }
        };
    }


    // @return an integer
    public int get(int key) {
        if(map.containsKey(key)) {
            return map.get(key);
        }else{
            return -1;
        }

    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        map.put(key,value);
    }


}
