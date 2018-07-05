package com.work.practice.Java.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2018-04-07-22:53
 * @email wangkai43@meituan.com
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        System.out.println(map.get("value"));

    }
}
