package com.algorithm.batAlgorithm.linkedlist;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/21.
 */
public class DivideTest {

    public static ListNode initListNode(){
        ListNode head = new ListNode((int)(Math.random()*10));
        ListNode point =head;
        for(int i=1;i<5;i++){
            point.next = new ListNode((int)(Math.random()*10));
         //   point.next = new ListNode(i);
            point = point.next;
        }
        return head;
    }

    @Test
    public void testdivide(){
        ListNode listNode = DivideTest.initListNode();

        Divide divide = new Divide();
        System.out.println("->"+divide.myString(listNode));
        ListNode head = divide.listDivide(listNode,5);
        System.out.println("->"+divide.myString(head));

    }
}
