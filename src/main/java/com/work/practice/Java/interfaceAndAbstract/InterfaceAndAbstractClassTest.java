package com.work.practice.Java.interfaceAndAbstract;

import org.junit.Test;

/**
 * Created by wangkai43 on 2017/6/20.
 */
public class InterfaceAndAbstractClassTest {
    @Test
    public void test(){
        RefundOrderBeansTalkIEventProcess refund = new RefundOrderBeansTalkIEventProcess();
        refund.say("practice");
        refund.process();
        refund.bye("practice");

    }
}
