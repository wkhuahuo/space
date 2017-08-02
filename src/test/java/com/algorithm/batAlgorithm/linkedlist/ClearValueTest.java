package com.wk.batAlgorithm.linkedlist;

import org.junit.Test;

/**
 * Created by wkhuahuo on 17/1/5.
 */
public class ClearValueTest {

    public static ListNode initListNode(int n,int range){
        ListNode head = new ListNode((int)(Math.random()*range));
        ListNode point =head;
        for(int i=1;i<n;i++){
            point.next = new ListNode((int)(Math.random()*range));
            //   point.next = new ListNode(i);
            point = point.next;
        }
        return head;
    }

    @Test
    public void testClear(){
        ClearValue clearValue = new ClearValue();
        ListNode listNode = initListNode(100,20);//初始化链表
        System.out.println("before: "+myString(listNode));

        listNode = clearValue.clear(listNode,9);//删除指定值

        System.out.println("after:  "+myString(listNode));
    }

    public static String myString(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode tmp = listNode;
        while(tmp!=null && tmp.next!=listNode){
            stringBuilder.append(tmp.val+",");
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
}
