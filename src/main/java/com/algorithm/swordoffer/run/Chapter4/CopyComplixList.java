package com.algorithm.swordoffer.run.Chapter4;


import com.algorithm.swordoffer.run.RandomListNode;

public class CopyComplixList {

    public RandomListNode Clone(RandomListNode pHead)
    {	
		if(pHead==null) return null;
        copyList(pHead);
        RandomListNode copiedHead = splitRandomList(pHead);
		return copiedHead;
    }

    private void copyList(RandomListNode pHead){
        RandomListNode tmpNode = pHead;
        //首先复制节点
        while(tmpNode != null){
            RandomListNode copiedNode = new RandomListNode(tmpNode.label);
            copiedNode.next = tmpNode.next;
            tmpNode.next = copiedNode;
            tmpNode = copiedNode.next;
        }
        tmpNode = pHead;//原来的头结点
        RandomListNode copied = null;//复制的节点
        while (tmpNode != null){ //为random节点赋值
            copied= tmpNode.next;//记录赋值的头结点
            if(tmpNode.random != null){
                copied.random =  tmpNode.random.next;
            }else{
                copied.random = null;
            }
            tmpNode = copied.next;

        }


    }
    private RandomListNode splitRandomList(RandomListNode pHead){
        RandomListNode copiedHead = pHead.next;
        RandomListNode copiedNode = null;
        RandomListNode node = pHead;

        while(node != null){//从节点node出发
            copiedNode = node.next;//得到node的复制节点copiedNode
            node.next =copiedNode.next;//更新node的下一个节点
            node = copiedNode.next;//更新node节点到新的位置
            copiedNode.next = (node == null? null:node.next);//如果node!=null则当前copiedNode.next为node.next否则为null
        }
        return copiedHead;

    }

}
