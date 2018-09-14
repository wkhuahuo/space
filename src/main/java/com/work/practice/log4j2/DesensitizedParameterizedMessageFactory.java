package com.work.practice.log4j2;

import org.apache.logging.log4j.message.*;

/**
 * @author wangkai43
 * @create 2018-09-13-14:24
 * @email wangkai43@meituan.com
 */
public class DesensitizedParameterizedMessageFactory extends AbstractMessageFactory{

    private ParameterizedMessageFactory messageFactory = ParameterizedMessageFactory.INSTANCE;

    @Override
    public Message newMessage(Object message){
        return messageFactory.newMessage(message);
    }

    @Override
    public Message newMessage(String message){
        return new DesensitizedParameterizedMessage(message);
    }


    @Override
    public Message newMessage(String message, Object... objects) {
        return new DesensitizedParameterizedMessage(message, objects);
    }

}
