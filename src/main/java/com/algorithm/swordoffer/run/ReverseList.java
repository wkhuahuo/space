package com.algorithm.swordoffer.run;

public class ReverseList {
	public ListNode ReverseList(ListNode head) {
		
		if(head == null) return null;
		if(head.next == null) return head;
		ListNode nodeLeft = head;
		ListNode nodeMid = head.next;
		ListNode nodeRight = null;
		if(nodeMid != null){
			nodeRight = nodeMid.next;
		}
		nodeLeft.next = null;
		while(nodeMid!=null){
			nodeMid.next = nodeLeft;
			nodeLeft = nodeMid;
			nodeMid = nodeRight;
			if(nodeRight!=null){
			nodeRight = nodeRight.next;
			}
		}
		head = nodeLeft;
		return head;
    }
}
