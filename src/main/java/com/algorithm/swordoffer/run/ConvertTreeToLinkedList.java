package com.algorithm.swordoffer.run;

/**
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：6713
 * 算法知识视频讲解
 * 题目描述:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by wkhuahuo on 2017/3/15.
 */
public class ConvertTreeToLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {

        return null;
    }

    private TreeNode inorder(TreeNode root, TreeNode father){

        if(root == null){
            return null;
        }


        TreeNode tmpnode = inorder(root.left, root);

        TreeNode tmpnode2 = inorder(root.right,root);


        return null;
    }
}
