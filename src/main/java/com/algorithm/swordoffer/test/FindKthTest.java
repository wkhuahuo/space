package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.FindKth;
import com.algorithm.swordoffer.run.ListNode;

import junit.framework.TestCase;

public class FindKthTest extends TestCase{
	public void test1(){
		System.out.println("test1");
	//	int[] intNum1 = {1,3,6,7,8};
		//int[] intNum1 = {1,2};
		int[] intNum1 = {1,2,7};
		LinkList lL1 = new LinkList();
		for(int i=0;i<intNum1.length;i++){
			lL1.addNode(intNum1[i]);
		}
		ListNode list1 = lL1.getFirst();
		FindKth fk = new FindKth();
		ListNode node = null;
		PrintLinkList.println(list1);
		
		node = fk.FindKthToTail(list1, 2);
		PrintLinkList.println(node);
		
	}
}
