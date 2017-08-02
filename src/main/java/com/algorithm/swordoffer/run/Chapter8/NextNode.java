package com.algorithm.swordoffer.run.Chapter8;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：4991
 算法知识视频讲解
 题目描述
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * Created by wkhuahuo on 2017/3/30.
 */
public class NextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }
        if(pNode.right ==null){

            return getFather(pNode);
        }else {
            return getleft(pNode.right);
        }

    }
    private TreeLinkNode  getFather(TreeLinkNode pNode){

        TreeLinkNode next =null;

        if(pNode == null){
            return next;
        }
        TreeLinkNode fa = pNode.next;
        if(fa == null){
            return next;
        }
        if(fa.left == pNode){
            next =fa;
            return next;
        }
        next = getFather(pNode.next);

        return next;
    }
    private TreeLinkNode getleft(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }
        TreeLinkNode tmp = getleft(pNode.left);
        if(tmp == null){
            return pNode;
        }
        return tmp;
    }
}
