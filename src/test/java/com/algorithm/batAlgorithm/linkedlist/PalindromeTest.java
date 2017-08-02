package com.algorithm.batAlgorithm.linkedlist;

import org.junit.Test;

/**
 * Created by wkhuahuo on 17-1-5.
 */
public class PalindromeTest {

    public static ListNode initListNode(int[] arr){
        if(arr==null || arr.length<1){
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode point =head;
        for(int i=1;i<arr.length;i++){
            point.next = new ListNode(arr[i]);
            point = point.next;
        }
        return head;
    }

    public static String myString(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode tmp = listNode;
        while(tmp!=null && tmp.next!=listNode){
            if(tmp.next==null){
                stringBuilder.append(tmp.val);
            }else {
                stringBuilder.append(tmp.val + ",");
            }
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }

    @Test
    public void isPalindromeTest(){
        int[] arr = {1,2,3,4,3,2,1};
        ListNode listNode = initListNode(arr);
        System.out.println(myString(listNode));
        Palindrome palindrome = new Palindrome();
        boolean bool= palindrome.isPalindrome(listNode);
        System.out.println(bool);
    }

    @Test
    public void reverseTest(){
        int[] arr = {1,2,3,4,3,2,1};
        ListNode listNode = initListNode(arr);
        System.out.println(myString(listNode));
        ListNode tailNode = listNode;
        if(tailNode == null){return;}
        Palindrome palindrome = new Palindrome();
        while(tailNode.next!=null){
            tailNode = tailNode.next;
        }
        ListNode tmpNode = palindrome.reverseList(listNode,tailNode);

    }

}
