package com.algorithm.swordoffer.run.Chapter4;

import com.algorithm.swordoffer.run.TreeNode;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class BinaryTreeAndDoubleLinkedList_27 {
   /* public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode DLinkedL = null;

        TreeNode root = pRootOfTree;
        TreeNode pre =null;
        ConvertNode(root,pre);

        while (pre.left!=null){
            pre = pre.left;
        }
        return pre;
    }
    private void ConvertNode(TreeNode pRootOfTree,TreeNode preNode){
        if(pRootOfTree == null){
            return ;
        }
        ConvertNode(pRootOfTree.left,preNode);
        if(preNode != null){
            preNode.right = pRootOfTree;
            pRootOfTree.left = preNode;
        }
        preNode = pRootOfTree;
        ConvertNode(pRootOfTree.right,preNode);

    }*/
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode DLinkedL = null;

        TreeNode root = pRootOfTree;

        TreeNode pre = ConvertNode(root,null);

        while (pre.left!=null){
            pre = pre.left;
        }
        return pre;
    }
    private TreeNode ConvertNode(TreeNode pRootOfTree,TreeNode pre){
        TreeNode preNode =pre;
        if(pRootOfTree == null){
            return preNode;
        }
        preNode = ConvertNode(pRootOfTree.left,preNode);
        if(preNode != null){
            preNode.right = pRootOfTree;
            pRootOfTree.left = preNode;
        }
        preNode = pRootOfTree;
        preNode = ConvertNode(pRootOfTree.right,preNode);
        return preNode;
    }

}
