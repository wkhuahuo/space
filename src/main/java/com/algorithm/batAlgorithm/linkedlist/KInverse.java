package com.algorithm.batAlgorithm.linkedlist;

/**
 * Created by wkhuahuo on 16/12/21.
 */
public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        if(head == null ||k<2){
            return head;
        }
        ListNode listNode = head;
        ListNode indexNode = head;
        ListNode tail = head;
        /*while (listNode != null){
            int count = 0;
            while(tail!=null && count<k){
                tail = tail.next;
                count++;
            }
            if(count ==3){
                overturn(indexNode,tail);
            }

        }*/
        head = overturn(head, tail);

        return head;
    }
    private ListNode overturn(ListNode head,ListNode tail){
        ListNode preNode = head;
        ListNode indexNode = preNode.next;
        if(indexNode == null){
            tail = head;
        }
        ListNode aftNode = indexNode.next;
        if(aftNode == null){
            head = indexNode;
            indexNode.next = preNode;
            preNode = null;
            tail = preNode;
        }
        while(aftNode.next!=null){
            indexNode.next = preNode;
            preNode = indexNode;
            indexNode = aftNode;
            aftNode = aftNode.next;
        }
        indexNode.next = preNode;
        aftNode.next = indexNode;
        head.next = null;
        head = aftNode;
        return head;
    }
}
