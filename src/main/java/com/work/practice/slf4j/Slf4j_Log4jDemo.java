package com.work.practice.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangkai43 on 2017/8/2.
 */
public class Slf4j_Log4jDemo {
    private final Logger logger = LoggerFactory.getLogger(Slf4j_Log4jDemo.class);
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

   public  void printException(){
        try{
            String name = "info";
            String value = "value";
            logger.info("info={}.value={}",name,value);
            throw new Exception("errorInfo");
        }catch (Exception e){
            String name = "name";
            logger.info("INFO错误名字:{}出现错误：{}",name, e);//只会打印错误信息不会打印栈信息
            logger.info("INFO错误名字:{}出现错误：",name, e);
            logger.error("ERROR错误名字：{}出现错误：{}",name, e);//只会打印错误信息不会打印栈信息
            logger.error("ERROR错误名字：{}出现错误：",name, e);

        }
    }
    public static void main(String[] args){

        System.setProperty("log4j.configuration", "log4j2.xml");
        Slf4j_Log4jDemo slf4j_log4jDemo = new Slf4j_Log4jDemo();
        slf4j_log4jDemo.setTemperature(1);
        slf4j_log4jDemo.setTemperature(55);

        slf4j_log4jDemo.printException();
    }
}
