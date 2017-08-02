package com.wk.batAlgorithm.linkedlist;

import org.junit.Test;

/**
 * Created by wkhuahuo on 16/12/21.
 */
public class KInverseTest {

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

    public static String myString(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode tmp = listNode;
        while(tmp!=null && tmp.next!=listNode){
            stringBuilder.append(tmp.val+",");
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }

    @Test
    public void testInverse(){
        KInverse kInverse = new KInverse();

        ListNode head =initListNode(8,20);//生产8个节点

        System.out.println(myString(head));
        ListNode result =kInverse.inverse(head,3);
        System.out.println(myString(result));
    }
}
