package com.algorithm.batAlgorithm.linkedlist;

import java.util.ArrayList;

/**
 * Created by wkhua on 16/12/21.
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class InsertValue {

    private ListNode init(int[] A,int[] nxt){
        ListNode head = new ListNode(A[0]);
        ListNode point = head;

        for(int i=0;i<nxt.length;i++) {
           if (nxt[i] != 0) {
                point.next = new ListNode(A[nxt[i]]);
                point = point.next;
            } else {
                point.next = head;
                break;
            }

        }
        return head;
    }


    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode tmpnode = new ListNode(val);
        if(A == null || A.length<1){
            return tmpnode;
        }
        ListNode head = init(A,nxt);
        if(tmpnode.val<=head.val){
            tmpnode.next = head;
            return tmpnode;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        boolean isFinded = false;
        while(cur!=head){
            isFinded = ( pre.val<val && val<=cur.val );
            if(isFinded){
                tmpnode.next = cur;
                pre.next = tmpnode;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(!isFinded) {
            tmpnode.next =cur;
            pre.next = tmpnode;
        }
        return head;
    }

    public String mytoString(ListNode head){
        ListNode point = head;
        ArrayList<Integer> arrlist = new ArrayList<>();
        while(point.next!=head){
            arrlist.add(point.val);
            point = point.next;
        }
        arrlist.add(point.val);
        return arrlist.toString();
    }

    public ListNode insert2(int[] A, int[] nxt, int val) {
        ListNode tmpnode = new ListNode(val);
        if(A == null || A.length<1){
            return tmpnode;
        }
        ListNode head = init2(A,nxt);
        if(tmpnode.val<=head.val){
            tmpnode.next = head;
            return tmpnode;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        boolean isFinded = false;
        while(cur!=null){
            isFinded = ( pre.val<val && val<=cur.val );
            if(isFinded){
                tmpnode.next = cur;
                pre.next = tmpnode;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(!isFinded) {
            tmpnode.next =cur;
            pre.next = tmpnode;
        }
        return head;
    }

    private ListNode init2(int[] A,int[] nxt){
        ListNode head = new ListNode(A[0]);
        ListNode point = head;

        for(int i=0;i<nxt.length-1;i++) {

                point.next = new ListNode(A[nxt[i]]);
                point = point.next;
        }
        return head;
    }
}
