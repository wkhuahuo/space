package com.work.practice.log4j2;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wangkai43
 * @create 2018-09-13-12:22
 * @email wangkai43@meituan.com
 */
public class LogTest {

    //private final static Logger logger = LogManager.getLogger(LogTest.class);
    private final static Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        //print();
        //printMap();
        //printMapinObj();
        //printArray();
        //printObject();
        printJsonObjectStr();
        //printJsonArrayStr();


    }

    private static void printJsonArrayStr(){
        String[] arr = {"123456","654321","987"};
        logger.info("arr:{}", JSON.toJSONString(arr));
        logger.info("phone:{}", JSON.toJSONString(arr));
    }


    private static void printJsonObjectStr(){
        MyInfo info = new MyInfo();
        logger.info("myInfo{}", JSON.toJSONString(info));
    }
    private static void printObject() {
        MyInfo info = new MyInfo();
        logger.info("myInfo:{}", info);
    }

    private static void printMap() {

        Map<String, String> mapStrKey = new HashMap<>();
        mapStrKey.put("phone", "12345678910");
        mapStrKey.put("name", "王锴");
        logger.info("mapStrKey:{}",mapStrKey);
    }
    private static void printMapinObj(){
        MyInfo info = new MyInfo();
        Map<String, Object> mapObj = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("qw");
        list.add("222");
        list.add("3333");
        mapObj.put("phone", info);
        mapObj.put("idNo", list);
        mapObj.put("name", "王锴锴");
        logger.info("mapObjValue:{}", mapObj);
    }

    private static void printArray(){
        String[] strarr = {"王锴", "123arr"};
        logger.info("info:{}",strarr);
        logger.info("personInfo:{}",strarr);
    }

    private static void print(){
        // Set up a simple configuration that logs on the console.
        Exception e = new NullPointerException("测试");
        logger.error("exception",e);
        logger.error("exception:{}",e);
        logger.info("wkwk",1,e);
        logger.info("wkwk{}",1,e);
        logger.info("wk", 111);
        logger.info("wk{}", "www", "KKK");
        MyInfo myInfo = new MyInfo();
        logger.info("message1:{} msg2:{} msg3:{}", 123, 456, 789);

        logger.info("info myInfo = {}", JSON.toJSONString(myInfo));
        logger.info("info myInfo = {}", myInfo);

        logger.error("myInfo = {}", myInfo, e);


    }


}
