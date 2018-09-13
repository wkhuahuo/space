package com.work.practice.log4j2;

import org.apache.logging.log4j.message.AbstractMessageFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.ObjectMessage;

/**
 * @author wangkai43
 * @create 2018-09-13-14:24
 * @email wangkai43@meituan.com
 */
public class SensitiveDataFilterFactory extends AbstractMessageFactory{

    public static final SensitiveDataFilterFactory sensitiveDataFilter = new SensitiveDataFilterFactory();

    @Override
    public Message newMessage(String s, Object... objects) {
        return null;
    }

    @Override
    public Message newMessage(Object message) {
        return null;
    }
}
