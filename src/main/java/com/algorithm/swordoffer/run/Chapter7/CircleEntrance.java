package com.algorithm.swordoffer.run.Chapter7;

import com.algorithm.swordoffer.run.ListNode;

/**
 * Created by wkhuahuo on 2017/3/30.
 */
public class CircleEntrance {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null){
            return pHead;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        do{
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }while(slow !=fast);

        slow =pHead;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
