package com.algorithm.batAlgorithm.linkedlist;

/**
 *

 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。

 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。

 * Created by wkhuahuo on 09/01/17.
 */
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode node1= findCircleNode(head1);
        ListNode node2= findCircleNode(head2);
        if(node1==null || node2==null){
            return false;
        }

        ListNode tmpNode = node1;
        do{
            if(tmpNode == node2){
                return true;
            }
            tmpNode = tmpNode.next;
        }while (tmpNode != node1);

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

}
