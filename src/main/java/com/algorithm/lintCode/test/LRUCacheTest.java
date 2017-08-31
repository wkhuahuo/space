package com.algorithm.lintCode.test;

import com.algorithm.lintCode.run.LRUCache1;
import com.algorithm.lintCode.run.LRUCache2;
import org.junit.Test;

/**
 * @author wangkai43
 * @create 2017-08-30-18:03
 * @email wangkai43@meituan.com
 */
public class LRUCacheTest {

    @Test
    public void testLRUCache1() {
        LRUCache1 l = new LRUCache1(2);
        l.set(2,1);
        l.set(1,1);
        System.out.println(l.get(2));
        l.set(4,1);
        System.out.println(l.get(1));
        System.out.println(l.get(2));

    }

    @Test
    public void testLRUCache2(){
        LRUCache2 l = new LRUCache2(10);
        l.set(7,28);
        l.set(7,1);
        l.set(8,15);
        System.out.println(l.get(6));
        l.set(10,27);
        l.set(8,10);
        System.out.println(l.get(8));
        l.set(6,29);
        l.set(1,9);
        System.out.println(l.get(6));
        l.set(10,7);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(13));
        l.set(8,30);
        l.set(1,5);
        System.out.println(l.get(1));
        l.set(13,2);
        System.out.println(l.get(12));
    }
}
