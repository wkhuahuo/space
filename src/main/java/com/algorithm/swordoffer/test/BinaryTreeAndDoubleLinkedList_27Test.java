package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.run.Chapter4.BinaryTreeAndDoubleLinkedList_27;
import com.algorithm.swordoffer.run.TreeNode;

/**
 * Created by wkhuahuo on 2017/3/24.
 */
public class BinaryTreeAndDoubleLinkedList_27Test {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);

        root.left = node;
        root.right = node1;
        BinaryTreeAndDoubleLinkedList_27 b = new BinaryTreeAndDoubleLinkedList_27();
        TreeNode result =b.Convert(root);
        if(result == null){
            System.out.println("Null");
        }else {
            System.out.println(result);
        }
    }
}
