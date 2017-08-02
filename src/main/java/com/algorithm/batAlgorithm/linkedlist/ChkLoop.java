package com.algorithm.batAlgorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 *

 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。

 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。

 * Created by wkhuahuo on 09/01/17.
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        if(head==null){
            return -1;
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
                return fastNode.val;
            }

        }
        return -1;
    }
    public int chkLoop1(ListNode head, int adjust) {
        Set<ListNode> headSet = new HashSet<>();
        ListNode indexNode = head;
        while(indexNode !=null){
            if(headSet.contains(indexNode)){
                return indexNode.val;
            }
            headSet.add(indexNode);
            indexNode = indexNode.next;
        }
        return -1;
    }
}
