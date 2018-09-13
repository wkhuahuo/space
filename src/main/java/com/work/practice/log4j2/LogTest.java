package com.work.practice.log4j2;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author wangkai43
 * @create 2018-09-13-12:22
 * @email wangkai43@meituan.com
 */
public class LogTest {

    private final static Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        // Set up a simple configuration that logs on the console.

        MyInfo myInfo = new MyInfo();
        logger.info("message1:{} msg2:{} msg3:{}", 123, 456, 789);

        logger.info("info myInfo = {}", JSON.toJSONString(myInfo));



    }
}
