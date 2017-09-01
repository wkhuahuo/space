package com.algorithm.lintCode.run;

/**
 * @author wangkai43
 * @create 2017-08-31-17:05
 * @email wangkai43@meituan.com
 */
public class IsCircleLinkedList {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        if(fast != null){
            fast = fast.next;
        }
        while(fast != slow){
            if(slow == null || fast == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return true;
    }
}
