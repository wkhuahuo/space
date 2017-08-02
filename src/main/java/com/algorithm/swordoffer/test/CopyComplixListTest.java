package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.Chapter4.CopyComplixList;
import com.algorithm.swordoffer.run.RandomListNode;

/**
 * Created by wkhuahuo on 2017/3/23.
 */
public class CopyComplixListTest {
    public static void main(String[] args){
        CopyComplixList cp = new CopyComplixList();
        RandomListNode root = new RandomListNode(1);
        RandomListNode tail = new RandomListNode(2);
        root.next = tail;
        root.random = tail;
        tail.random = root;
        RandomListNode random = cp.Clone(root);
        RandomListNode tmp = random;
        while(tmp!=null){
            System.out.print(tmp.label+" ");
            tmp = tmp.next;
        }
    }
}
