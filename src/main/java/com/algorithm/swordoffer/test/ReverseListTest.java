package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.ListNode;
import com.algorithm.swordoffer.run.ReverseList;

import junit.framework.TestCase;

public class ReverseListTest extends TestCase{
	
	public void test1(){
		System.out.println("test1");
	//	int[] intNum1 = {1,3,6,7,8};
		//int[] intNum1 = {1,2};
		int[] intNum1 = {7};
		LinkList lL1 = new LinkList();
		for(int i=0;i<intNum1.length;i++){
			lL1.addNode(intNum1[i]);
		}
		ListNode list1 = lL1.getFirst();
		ReverseList rl = new ReverseList();
		
		PrintLinkList.println(list1);
		
		list1 = rl.ReverseList(list1);
		PrintLinkList.println(list1);
		
	}
}
