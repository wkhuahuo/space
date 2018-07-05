package com.work.practice.Java.JVMDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai43
 * @create 2017-09-13-19:08
 * @email wangkai43@meituan.com
 */
public class HeapOOM {
    /**
     * VM Args: -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
