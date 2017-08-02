package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.ListNode;
import com.algorithm.swordoffer.run.Merge;

import junit.framework.TestCase;

public class MergeTest extends TestCase{
	public void test1(){
		System.out.println("test1");
		int[] intNum1 = {1,3,6,7,8};
		int[] intNum2 = {2,4,5,9};
		LinkList lL1 = new LinkList();
		LinkList lL2 = new LinkList();
		for(int i=0;i<intNum1.length;i++){
			lL1.addNode(intNum1[i]);
		}
		ListNode list1 = lL1.getFirst();
		for(int i=0;i<intNum2.length;i++){
			lL2.addNode(intNum2[i]);
		}
		ListNode list2 = lL2.getFirst();
	//	System.out.println(list2.toString());
		
		ListNode list3 = null;
		Merge mer = new Merge();
		
		list3 = mer.Merge(list1, list2);
		PrintLinkList.println(list1);
		PrintLinkList.println(list2);
		PrintLinkList.println(list3);
	}
	public void test2(){
		System.out.println("test2");
		int[] intNum1 = {1,3,6,7,8};
		int[] intNum2 = {2,4,5,9};
		LinkList lL1 = new LinkList();
		LinkList lL2 = new LinkList();
		for(int i=0;i<intNum1.length;i++){
			lL1.addNode(intNum1[i]);
		}
		ListNode list1 = lL1.getFirst();
		for(int i=0;i<intNum2.length;i++){
			lL2.addNode(intNum2[i]);
		}
		ListNode list2 = lL2.getFirst();
	//	System.out.println(list2.toString());
		
		ListNode list3 = null;
		Merge mer = new Merge();
		
		list3 = mer.Merge3(list1, list2);
		PrintLinkList.println(list1);
		PrintLinkList.println(list2);
		PrintLinkList.println(list3);
	}
	
}
