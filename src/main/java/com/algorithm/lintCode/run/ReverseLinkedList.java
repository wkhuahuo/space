package com.algorithm.lintCode.run;

/**
 * @author wangkai43
 * @create 2017-08-31-16:44
 * @email wangkai43@meituan.com
 */
public class ReverseLinkedList {
    /*
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode pos = head.next;
        pre.next = null;
        while (pos!=null){
            ListNode aft = pos.next;
            pos.next = pre;
            pre = pos;
            pos = aft;
        }
        return pre;
    }
}
