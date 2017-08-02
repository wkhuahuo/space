package com.work.practice.slf4j;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by wangkai43 on 2017/8/1.
 */
public class Log4jDemo {

    private static final Logger logger = Logger.getLogger(Log4jDemo.class.getName());


    public static void main(String args[]) {
        // Try a few logging methods
        logger.debug("Start of main()");
        logger.info("Just testing a log message with priority set to INFO");
        logger.warn("Just testing a log message with priority set to WARN");
        logger.error("Just testing a log message with priority set to ERROR");
        logger.fatal("Just testing a log message with priority set to FATAL");

        // Alternate but INCONVENIENT form
        logger.debug("Calling init()");


    }

}
