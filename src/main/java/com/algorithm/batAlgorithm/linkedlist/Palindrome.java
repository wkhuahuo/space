package com.algorithm.batAlgorithm.linkedlist;

import java.util.Stack;

/**
 * Created by wkhuahuo on 17/1/5.
 * 请编写一个函数，检查链表是否为回文。
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead){
        ListNode hNode = pHead;
        ListNode mNode = pHead;
        ListNode tNode = pHead;
        while(tNode.next!=null){
            mNode = mNode.next;
            tNode = tNode.next;
            if(tNode.next!=null){
                tNode = tNode.next;
            }else {
                break;
            }

        }
        reverseList(mNode,tNode);




        return true;
    }

    public ListNode reverseList(ListNode mNode, ListNode tNode) {

        return null;
    }

    public boolean isPalindrome2(ListNode pHead){
        Stack<Integer> stack = new Stack<>();
        ListNode slowNode = pHead;
        ListNode fastNode = pHead;
        boolean isOdd = true;
        while(fastNode != null){
            stack.push(slowNode.val);
            fastNode = fastNode.next;
            if(fastNode !=null){
                isOdd = false;
                fastNode = fastNode.next;
            }else{
                isOdd = true;
                //fastNode ;
            }
            slowNode = slowNode.next;
        }
        if(isOdd){
            stack.pop();
        }
        while(!stack.empty() && slowNode!=null){
            if(slowNode.val != stack.pop()) {
                return false;
            }
            slowNode = slowNode.next;
        }
        return true;
    }
    public boolean isPalindrome1(ListNode pHead) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmpNode = pHead;
        while(tmpNode!=null){
            stack.push(tmpNode.val);
            tmpNode = tmpNode.next;
        }
        tmpNode = pHead;
        while(tmpNode!=null){
            if(tmpNode.val != stack.pop()){
                return false;
            }
            tmpNode = tmpNode.next;
        }
        return true;
    }




}
