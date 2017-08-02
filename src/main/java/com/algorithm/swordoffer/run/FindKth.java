package com.algorithm.swordoffer.run;

public class FindKth {
	 public ListNode FindKthToTail(ListNode head,int k) {
		 if(head == null || k == 0 ){return null;}
		 ListNode nodeEnd = head;
		 ListNode nodeStart = null;
		 while(k >0 && nodeEnd != null){
			 nodeEnd = nodeEnd.next;
			 k--;
		 }
		 if(k>0){
			 return null;
		 }
		 
		 nodeStart = head;
		 while(nodeEnd != null){
			 nodeEnd = nodeEnd.next;
			 nodeStart = nodeStart.next;
		 }
		 return nodeStart;
	 }
}
