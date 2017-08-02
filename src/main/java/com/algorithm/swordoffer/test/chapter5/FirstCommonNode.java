package com.algorithm.swordoffer.test.chapter5;


import com.algorithm.swordoffer.run.ListNode;


/**
 * 时间限制：1秒 空间限制：32768K 热度指数：7833
 本题知识点： 链表
 算法知识视频讲解
 题目描述
 输入两个链表，找出它们的第一个公共结点。
 * Created by wkhuahuo on 2017/3/27.
 */
public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1Node = isCircle(pHead1);
        ListNode p2Node = isCircle(pHead2);
        if(p1Node == null || p2Node == null){
            if(p1Node == null && p2Node == null) {
                return getNodeUnCircle(pHead1, pHead2);
            }else{ return null;}
        }
        if(p1Node == p2Node){
            return p1Node;
        }

        ListNode tmpNode = p1Node;
        tmpNode  = tmpNode.next;
        while (tmpNode !=p1Node){
            if(tmpNode == p2Node){
                return tmpNode;
            }
            tmpNode = tmpNode.next;
        }

        int pL1 = getLength(pHead1,p1Node);
        int pL2 = getLength(pHead2,p2Node);

        ListNode tmpNode1 =pHead1;
        ListNode tmpNode2 =pHead2;
        if(pL1>pL2) {
            int cha = pL1-pL2;
            while (cha > 0) {
                tmpNode1 = tmpNode1.next;
                cha--;
            }
        }else if(pL1<pL2){
            int cha = pL2 - pL1;
            while (cha >0){
                tmpNode2 =tmpNode2.next;
                cha--;
            }
        }

        while(tmpNode1 != tmpNode2 &&tmpNode1!=p1Node && tmpNode2 != p2Node ){
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }
        if(tmpNode1 == tmpNode2){
            return tmpNode1;
        }

        return null;
    }

    /***
     * 判断是否有环
     * @param head
     * @return  ListNode    如果存在环，返回入口节点
     *          NULL        如果不存在环，返回null
     */
    private ListNode isCircle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast !=null){
            fast = fast.next;
            count++;
            if(count == 2) {
                slow = slow.next;
                count =0;
                if(slow == fast){
                    return getEntrance(head,slow);
                }
            }
        }
        return null;
    }

    /***
     * 输入
     * @param head      链表头结点
     * @param meetNode  环中的某一节点，快慢指针相遇节点
     * @return ListNode 入口节点
     *         null     空
     */
    private ListNode getEntrance(ListNode head,ListNode meetNode){
        if(head == null || meetNode == null){
            return null;
        }
        ListNode nodeB = head;
        ListNode nodeM = meetNode;
        while(nodeB != nodeM){
            nodeB = nodeB.next;
            nodeM = nodeM.next;
        }
         return nodeM;
    }
    /***
     * 判断两个有环链表是否相交
     * @param pHead1
     * @param pHead2
     * @return  ListNode    如果相交，返回相交节点
     *          NULL        如果不想交，返回空
     */
    private ListNode getNodeCircle(ListNode pHead1, ListNode pHead2){
        return null;
    }

    /***
     * 判断无环链表是否相交
     * @param pHead1
     * @param pHead2
     * @return  ListNode    相交返回相交节点
     *          NULL        不相交返回该节点
     */
    private ListNode getNodeUnCircle(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int p1Length = getLength(pHead1,null);
        int p2Length = getLength(pHead2,null);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        if(p1Length>p2Length) {
            int cha = p1Length-p2Length;
            while (cha > 0) {
                p1 = p1.next;
                cha--;
            }
        }else if(p1Length<p2Length){
            int cha = p2Length - p1Length;
            while (cha >0){
                p2 =p2.next;
                cha--;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private int getLength(ListNode pHead1,ListNode end){

        int length =0;
        ListNode tmp = pHead1;
        while (tmp!=end){
            tmp = tmp.next;
            length++;
        }
        return length;
    }
}
