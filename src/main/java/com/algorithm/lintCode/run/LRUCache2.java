package com.algorithm.lintCode.run;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2017-08-30-18:08
 * @email wangkai43@meituan.com
 */
public class LRUCache2 {

    private final int MAX_CAPACITY;
    private int nodes;

    Map<Integer,Node> map = new HashMap<>();
    Node head = null;
    Node tail = head;
    // @param capacity, an integer
    public LRUCache2(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    // @return an integer
    public int get(int key) {
        if(map.containsKey(key)){
            Node node =map.get(key);
            moveToFirst(node);
            return node.value;
        }
        return -1;

    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(map.containsKey(key)){//因为之前存在，只调整位置信息
            Node node = map.get(key);
            node.value = value;
            moveToFirst(node);
        }else{ //之前不存在需要插入
            Node node = new Node(key,value);
            map.put(key,node);
            nodes ++;
            if(head != null) {//已经有节点
                head.pre = node;
                node.next = head;
                node.pre = null;
                head = node;
            }else{//之前还没有节点
                head = node;
                tail = node;
            }
        }
        while (tail.next!=null){//把tail推到尾节点
            tail = tail.next;
        }
        if(map.size() > MAX_CAPACITY){//如果查出容量限制则删除
            int count = map.size() - MAX_CAPACITY;
            while(count-->0){
                map.remove(tail.key);
                tail = tail.pre;
                count --;
            }
            if(tail.next != null) {
                tail.next.pre = null;
            }
            tail.next = null;
        }
    }
    private void moveToFirst(Node node){
        //判断是否是头节点
        if(head == node){
            return;
        }
        //第二个节点及其以后
        if(node.next != null){//不是尾节点
            //摘除
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
            //插入头部
            head.pre = node;
            node.next = head;
            //调整头结点
            head = node;
        }else{//是尾节点
            //摘除
            node.pre.next = null;
            node.pre = null;
            //插入头部
            head.pre = node;
            node.next = head;
            //调整头结点
            head = node;
        }
    }

    class Node {
        Node pre;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
