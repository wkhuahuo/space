package com.wk.batAlgorithm.linkedlist;

import junit.framework.Assert;
import org.junit.Test;



/**
 * Created by wkhua on 16/12/21.
 */
public class RemoveTest {

    public ListNode initListNode(){
        ListNode head = new ListNode(0);
        ListNode point =head;
        for(int i=1;i<5;i++){
        //    point.next = new ListNode((int)(Math.random()*100));
            point.next = new ListNode(i);
            point = point.next;
        }
        return head;
    }
    @Test
    public void testRemoveNode(){
        Remove remove = new Remove();

        ListNode listNode = initListNode();

    }
}
