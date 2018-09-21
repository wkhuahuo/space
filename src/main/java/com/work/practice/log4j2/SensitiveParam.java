package com.work.practice.log4j2;

/**
 * Created by wangkai43 on 2018/9/17.
 */
public abstract class SensitiveParam {

    public static final String STAR = "***";


    /**
     * 脱敏规则
     * @param obj
     * @return
     */
    public abstract Object desensitizedRule(Object obj);

    /**
     * 参数名称
     * @return
     */
    public abstract String getParamName();


}
