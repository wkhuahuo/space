package com.work.practice.Java.interfaceAndAbstract;

/**
 * Created by wangkai43 on 2017/6/20.
 */
public class RefundOrderBeansTalkIEventProcess extends BeansTalkIEventProcess {
    @Override
    public void process() {
        System.out.println("My process");
    }

    @Override
    public void bye(String name) {
        System.out.println("goodbye "+name);
    }
}
