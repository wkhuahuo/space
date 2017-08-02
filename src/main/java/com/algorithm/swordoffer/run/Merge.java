package com.algorithm.swordoffer.run;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
题目描述

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
*/
public class Merge {
	
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 ==null) return list2;
		if(list2 ==null) return list1;
		ListNode list3 = null;
		if(list1.val<=list2.val){
			 list3=new ListNode(list1.val);
			list3.next=Merge(list1.next,list2);
		}
		if(list2.val<list1.val){
			list3=new ListNode(list2.val);
			list3.next=Merge(list2.next,list1);
		}
		
		return list3;
    }
	
	public ListNode Merge2(ListNode list1, ListNode list2){
		if(list1==null)return list2;
		if(list2==null)return list1;
		
		ListNode position3 = null;
		ListNode list3 = new ListNode(0);
		ListNode position1 = list1;
		ListNode position2 = list2;
		
		position3 = list3;
		while(position1!=null && position2!=null){
			if(position1.val<=position2.val){
				position3.next=position1;
				position1 = position1.next;
			}else{
				position3.next = position2;
				position2 = position2.next;
			}
			position3 = position3.next;
		}
		if(position1==null) position3.next = position2;
		if(position2==null) position3.next = position1;
		return list3.next;
	}
	
	public ListNode Merge3(ListNode list1, ListNode list2){
		if(list1==null)return list2;
		if(list2==null)return list1;
		
		ListNode position3 = null;
		ListNode list3 = new ListNode(0);
		ListNode position1 = list1;
		ListNode position2 = list2;
		
		position3 = list3;
		while(position1!=null && position2!=null){
			if(position1.val<=position2.val){
				position3.next=new ListNode(position1.val);
				
				position1 = position1.next;
			}else{
				position3.next = new ListNode(position2.val);;
				position2 = position2.next;
			}
			position3 = position3.next;
		}
		if(position1==null) position3.next = position2;
		if(position2==null) position3.next = position1;
		return list3.next;
	}
}

