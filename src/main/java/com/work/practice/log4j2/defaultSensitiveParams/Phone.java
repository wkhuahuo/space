package com.work.practice.log4j2.defaultSensitiveParams;


import com.work.practice.log4j2.SensitiveParam;

/**
 * @author wangkai43
 * @create 2018-09-18-11:03
 * @email wangkai43@meituan.com
 */
public class Phone extends SensitiveParam {

    private final String PARAMNAME = "phone";




    @Override
    public Object desensitizedRule(Object obj) {
        String tmpStr = "";
        if(obj instanceof String){
            String str = (String ) obj;
            int length = str.length();
            if (length>3) {
                tmpStr = str.substring(0, 3) + STAR + str.substring(length - 3, length);
            } else {
                tmpStr = STAR;
            }
        }
        return tmpStr;
    }

    @Override
    public String getParamName() {
        return PARAMNAME;
    }

}
