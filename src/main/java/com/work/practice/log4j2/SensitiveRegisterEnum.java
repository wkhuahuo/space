package com.work.practice.log4j2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangkai43
 * @create 2018-09-18-12:29
 * @email wangkai43@meituan.com
 */
public enum SensitiveRegisterEnum {

    // 脱敏注册器单例
    SENSITIVE_REGISTER;


    private static Logger logger = LoggerFactory.getLogger(SensitiveRegisterEnum.class);
    private final static SensitiveParamRegister<SensitiveParam> sensitiveParamRegister = new SensitiveParamRegister<>();

    public SensitiveParam getSensitiveParamByName(String name) {
        SensitiveParam t = sensitiveParamRegister.getSensitiveParamByName(name);
        if(t == null ){
            return null;
        }
        return t;
    }

    // 是否可以优化？
    public Object desenByLikesKey(String param, Object obj ){
        for (String key : sensitiveParamRegister.getKeySet()){
            if(param.contains(key)){
                SensitiveParam sensitiveParam = sensitiveParamRegister.getSensitiveParamByName(key);
                if(sensitiveParam != null){
                    return sensitiveParam.desensitizedRule(obj);
                }
            }
        }
        return obj ;
    }

    /**
     * 给出当前的KeySet中是否有该敏感关键词
     * @param param
     * @return
     */
    public boolean containsKey(String param ){
        try {
            return sensitiveParamRegister.getKeySet().contains(param);
        } catch (Exception e) {
            logger.error("参数类型非法。异常信息为：{}", e.getMessage());
        }
        return false;
    }

}
