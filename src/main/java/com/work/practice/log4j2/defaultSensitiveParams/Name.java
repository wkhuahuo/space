package com.work.practice.log4j2.defaultSensitiveParams;


import com.work.practice.log4j2.SensitiveParam;

/**
 * @author wangkai43
 * @create 2018-09-18-14:23
 * @email wangkai43@meituan.com
 */
public class Name extends SensitiveParam {

    @Override
    public Object desensitizedRule(Object obj) {

        String tmpStr = "";
        if(obj instanceof String) {
            String str = (String) obj;
            int length = str.length();
            if(length > 1){
                tmpStr = str.substring(0,1);
            }else {
                tmpStr = str;
            }
        }
        return tmpStr+STAR;
    }


    @Override
    public String getParamName() {
        return "name";
    }
}
