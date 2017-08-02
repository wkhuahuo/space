package com.algorithm.batAlgorithm.linkedlist;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 16/12/21.
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 测试样例：
 {1,2,3,4,5,6,7},{2,4,6,8,10}
 返回：[2.4.6]
 */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {

        ArrayList<Integer> arrList = new ArrayList<>();

        ListNode indexA = headA;
        ListNode indexB = headB;
        while(indexA!=null && indexB!=null){
            if(indexA.val > indexB.val){
                indexB = indexB.next;
            }else if(indexA.val < indexB.val){
                indexA = indexA.next;
            }else {
                arrList.add(indexA.val);
                indexA = indexA.next;
                indexB = indexB.next;
            }
        }
         int size = arrList.size();
        int[] arr = new int[size];
        int count=0;
        for(int a:arrList){
            arr[count++] = a;
        }
        return arr;
    }
}
