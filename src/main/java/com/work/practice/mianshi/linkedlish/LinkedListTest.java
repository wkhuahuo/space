package com.work.practice.mianshi.linkedlish;

import java.util.LinkedList;

/**
 * Created by wkhuahuo on 19/02/17.
 */
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<Integer> linkedlist = new LinkedList<>();
        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);
        int m = linkedlist.get(2);
        System.out.println(m);
    }
}
