package com.algorithm.swordoffer.run;
import java.util.ArrayList;
import java.util.Stack;

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
public class PrintList {
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		if(listNode == null) return arrList ;
		
		Stack<Integer> tmpStack = new Stack<Integer>();
		while(listNode!=null){
			tmpStack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!tmpStack.isEmpty()){
			arrList.add(tmpStack.pop());
		}
		return arrList;
	        
	}
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		if(listNode!=null){
			
			if(listNode.next!=null){
				arrList.addAll(printListFromTailToHead(listNode.next));
				arrList.add(listNode.val);
			}else{
				arrList.add(listNode.val);
			}
		}
		
		return arrList;
		
	}
	
}
