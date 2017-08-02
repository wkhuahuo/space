package com.algorithm.batAlgorithm.linkedlist;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 09/01/17.
 */
public class MyUtil {
    /**
     * 输入：单链表头结点ListNode
     * 输出： 用字符串表示这个单链表
     * @param listNode
     * @return String
     */
    public static String myString(ListNode listNode) {
        if(listNode ==null){
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        ListNode tmp = listNode;
        while(tmp!=null && tmp.next!=listNode){
            if(tmp.next==null){
                stringBuilder.append(tmp.val);
            }else {
                stringBuilder.append(tmp.val + ",");
            }
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
    /**
     * 输入：单链表头结点ListNode
     * 输出： 用字符串表示这个单链表
     * @param headNode
     * @return String
     */
    public static String myString(RandomListNode headNode) {
        if(headNode ==null){
            return "<>";
        }

        int NULLDATA = -1;
        int VISITED = -2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder randomStrBuilder = new StringBuilder();
        ArrayList<RandomListNode> lableArrList= new ArrayList<>();
        RandomListNode tmp = headNode;

        while(tmp!=null){
            lableArrList.add(tmp);
            tmp = tmp.next;
        }
        tmp = headNode;
        stringBuilder.append("<");
        while(tmp!=null && tmp.next!=headNode){

            if(tmp.next==null){
                stringBuilder.append(tmp.label+":");
                randomStrBuilder.append(tmp.random ==null ? NULLDATA+">": lableArrList.indexOf(tmp.random)+">");
            }else {
                stringBuilder.append(tmp.label + ",");
                randomStrBuilder.append(tmp.random ==null ? NULLDATA+",": lableArrList.indexOf(tmp.random)+",");
            }
            tmp = tmp.next;
        }
        return stringBuilder.toString()+randomStrBuilder.toString();
    }


    /**
     * 输入 int型数组
     * 输出 构建好的单链表List的头结点ListNode
     * @param arr
     * @return ListNode
     */
    public static ListNode initListNode(int[] arr){
        if(arr==null || arr.length<1){
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode point =head;
        for(int i=1;i<arr.length;i++){
            point.next = new ListNode(arr[i]);
            point = point.next;
        }
        return head;
    }

    public static RandomListNode initRandomListNode(int[] next,int[] random){
        if(next==null || next.length<1){
            return null;
        }
        RandomListNode head = new RandomListNode(next[0]);
        RandomListNode point =head;
        for(int i=1;i<next.length;i++){
            point.next = new RandomListNode(next[i]);
            point = point.next;
        }
    //    System.out.println(myString(head));//打印当前的RandemListNode

        point = head;
        int index=0;
        while(point!=null){
            int count = random[index];//表示从头结点开始往后的第count位置的节点是random节点
            if(count == -1) {
                point.random = null;
            }else {
                RandomListNode tmpNode = null;//新建临时节点
                tmpNode = head;//临时指向point
                while (count > 0 && head !=null) {
                    tmpNode = tmpNode.next;
                    count--;
                }
                point.random = tmpNode;
            }
            point = point.next;
            index++;
        }

    //    System.out.println(myString(head));



        return head;
    }
}
