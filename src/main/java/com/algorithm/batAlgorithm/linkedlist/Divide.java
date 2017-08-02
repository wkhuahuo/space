package com.algorithm.batAlgorithm.linkedlist;

/**
 * Created by wkhua on 16/12/21.
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 测试样例：
 {1,4,2,5},3
 {1,2,4,5}
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        ListNode tmpNode = head;
        ListNode smaller=null;
        ListNode smallerb=smaller;
        ListNode bigger=null;
        ListNode biggerb=bigger;
        ListNode equal=null;
        ListNode equalb=equal;
        while(tmpNode!=null){
            if(tmpNode.val<val){//当为：if(tmpNode.val<=val)时变成双色问题，可以通过牛客网oj。此为三色问题。
                if(smallerb==null) {
                    smaller = tmpNode;
                    smallerb = smaller;
                }else {
                    smaller.next = tmpNode;
                    smaller = smaller.next;
                }
                tmpNode= tmpNode.next;
                smaller.next = null;

            }else if(tmpNode.val>val){
                if(biggerb==null) {
                    bigger = tmpNode;
                    biggerb = bigger;
                }else {
                    bigger.next=tmpNode;
                    bigger = bigger.next;
                }
                tmpNode= tmpNode.next;
                bigger.next = null;
            }else {
                if(equalb==null) {
                    equal = tmpNode;
                    equalb = equal;
                }else {
                    equal.next =tmpNode;
                    equal = equal.next;
                }
                tmpNode= tmpNode.next;
                equal.next = null;
            }
        }

        if(smallerb ==null){
            if(equalb ==null){
                head = biggerb;
            }else {
                head = equalb;
                if(biggerb!=null){
                    equal.next=biggerb;
                }
            }

        }else{
            head = smallerb;
            if(equalb!=null){
                smaller.next = equalb;
                if(biggerb != null){
                    equal.next = biggerb;
                }
            }else if(biggerb != null){
                smaller.next = biggerb;
            }

        }

/*

        head = smallerb;
        ListNode tailNode = smaller;
        if(smallerb != null){
            smaller.next = equalb;
        }else {
            tailNode = equalb;
        }
        tailNode = equal;

        if(tailNode != null){
            equal.next = biggerb;
        }else {
            tailNode = biggerb;
        }
        tailNode = bigger;
*/



        return head;
    }

    public String myString(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode tmp = listNode;
        while(tmp!=null && tmp.next!=listNode){
            stringBuilder.append(tmp.val+",");
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
}
