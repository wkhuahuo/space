package com.algorithm.batAlgorithm.linkedlist;

/**
 * Created by wkhuahuo on 09/01/17.
 */
public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        // write code here
        if(headA ==null || headB == null){
            return false;
        }

        int count =0;
        ListNode tmpNode = headA;
        while(tmpNode !=null){
            tmpNode = tmpNode.next;
            count++;
        }
        tmpNode = headB;
        while(tmpNode !=null){
            tmpNode = tmpNode.next;
            count--;
        }
        tmpNode = headA;
        ListNode tmpNodeb = headB;
        if(count>0){
            tmpNode = tmpNode.next;
            count--;
        }
        while(tmpNode !=null){
            if(tmpNode == tmpNodeb){
                return true;
            }
            tmpNode = tmpNode.next;
            tmpNodeb = tmpNodeb.next;
        }

        return false;
    }
}
