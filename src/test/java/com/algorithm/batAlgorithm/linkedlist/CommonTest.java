package com.wk.batAlgorithm.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wkhuahuo on 16/12/21.
 */
public class CommonTest {
    public static ListNode initListNode(int n,int step){
        ListNode head = new ListNode(0+(int)(1+Math.random()*(step+1-1)));
        ListNode point =head;
        for(int i=1;i<n*step;i+=step){
            point.next = new ListNode(i+(int)(1+Math.random()*(step+1-1)));
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
    public void testFindCommonParts(){
        Common common = new Common();
        ListNode headA = initListNode(6,5);
        ListNode headB = initListNode(8,4);
        System.out.println(myString(headA));
        System.out.println(myString(headB));
        int[] result = common.findCommonParts(headA, headB);
        System.out.print(Arrays.toString(result));

    }
}
