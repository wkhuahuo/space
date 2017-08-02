package com.algorithm.batAlgorithm.linkedlist;

/**
 *

 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不相交的话返回false。

 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。

 * Created by wkhuahuo on 09/01/17.
 */
public class ChkIntersectionComplex {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode node1= findCircleNode(head1);
        ListNode node2= findCircleNode(head2);
        if(node1 == null && node2 ==null){
            return chkIntersect(node1,node2);
        }
        if(node1 != null && node2 !=null){
            ListNode tmpNode = node1;
            do{
                if(tmpNode == node2){
                    return true;
                }
                tmpNode = tmpNode.next;
            }while (tmpNode != node1);

        }
        return false;
    }

    private ListNode findCircleNode(ListNode head){
        if(head==null){
            return null;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode !=null && fastNode.next !=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(fastNode == slowNode){
                fastNode = head;
                while(fastNode !=slowNode){
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return fastNode;
            }

        }
        return null;
    }


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
