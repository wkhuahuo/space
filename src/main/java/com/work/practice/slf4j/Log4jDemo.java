package work.wk.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangkai43 on 2017/8/1.
 */
public class Log4jDemo {
    final Logger logger = LoggerFactory.getLogger(Log4jDemo.class);
    Integer t;
    Integer oldT;
    public void setTemperature(Integer temperature){
        oldT = t;
        t = temperature;
        logger.error("Temperature set to {}. Old temperature was {}",t, oldT);
        if(temperature.intValue() > 50){
            logger.info(" Temmperature has risen above 50 degree. ");
        }
    }
    public static void main(String[] args){
        Log4jDemo log4jDemo = new Log4jDemo();
        log4jDemo.setTemperature(1);
        log4jDemo.setTemperature(55);
    }
}
