package com.algorithm.leetcode.contest;

/**
 * @author wangkai43
 * @create 2017-08-30-14:23
 * @email wangkai43@meituan.com
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode position = head;
        int ge;
        int upper = 0;
        while (l1!=null && l2 != null){
            ge = (l1.val+l2.val+upper)%10;
            upper = (l1.val+l2.val+upper)/10;
            position.next = new ListNode(ge);
            position = position.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null){
            ge = (l1.val+upper)%10;
            upper = (l1.val + upper)/10;
            position.next = new ListNode(ge);
            position = position.next;
            l1 = l1.next;
        }
        while (l2!=null){
            ge = (l2.val + upper)%10;
            upper = (l2.val + upper)/10;
            position.next = new ListNode(ge);
            position = position.next;
            l2 = l2.next;
        }

        while (upper != 0){
            ge = (upper)%10;
            upper = upper/10;
            position.next = new ListNode(ge);
            position = position.next;
        }

        return head.next;
    }
}
