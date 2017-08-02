package com.algorithm.batAlgorithm.linkedlist;

/**
 * Created by wkhuahuo on 09/01/17.
 */
public class RandomListNodeCopy {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode indexNode = pHead;
        while(indexNode !=null){
            RandomListNode copyedNode = new RandomListNode(indexNode.label);
            copyedNode.next = indexNode.next;

            indexNode.next = copyedNode;
            indexNode = copyedNode.next;
        }
        indexNode = pHead;
        while(indexNode !=null){
            if(indexNode.random==null){
                indexNode.next.random = null;
            }else {
                indexNode.next.random = indexNode.random.next;
            }
            indexNode = indexNode.next.next;
        }

        indexNode = pHead;

        RandomListNode copyedHead = pHead.next;
        RandomListNode copyedNode = copyedHead;
        while(copyedNode.next!=null){

            indexNode.next = copyedNode.next;
            indexNode = indexNode.next;
            copyedNode.next = indexNode.next;
            copyedNode = copyedNode.next;
        }
        indexNode.next =null;
        return copyedHead;
    }
}
