package com.work.practice.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangkai43 on 2017/8/2.
 */
public class Slf4j_Log4jDemo {
    final Logger logger = LoggerFactory.getLogger(Log4jDemo.class);
    Integer t;
    Integer oldT;
    public void setTemperature(Integer temperature){
        oldT = t;
        t = temperature;
        logger.error("Temperature set to {}. Old temperature was {}",t, oldT);
        if(temperature > 50){
            logger.info("Temmperature has risen above 50 degree. ");
        }
    }
    public static void main(String[] args){
        System.setProperty("log4j.configuration", "log4j.properties");
        Slf4j_Log4jDemo slf4j_log4jDemo = new Slf4j_Log4jDemo();
        slf4j_log4jDemo.setTemperature(1);
        slf4j_log4jDemo.setTemperature(55);
    }
}
