package com.algorithm.batAlgorithm.binaryTree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by wkhuahuo on 16/02/17.
 */
public class MaxSubtreeTest {

    public static TreeNode initTreeNode(char[] arr){
        if(arr==null || arr.length<1){
            return null;
        }
        int length = arr.length;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(arr[0]);
        nodeQueue.add(root);
        int index =0;
        while(index<length/2){
            TreeNode treeNode = nodeQueue.poll();
            if(arr[2*index+1] != '#'){
                treeNode.left = new TreeNode(arr[2*index+1]);
                nodeQueue.add(treeNode.left);

            }else{
                treeNode.left = null;
            }
            if(2*index+2<length && arr[2*index+2] != '#') {
                treeNode.right = new TreeNode(arr[2 * index + 2]);
                nodeQueue.add(treeNode.right);
            }else{
                treeNode.right = null;
            }
            index++;
        }
        System.out.println("index= "+index);

        return root;
    }

    @Test
    public void getMaxTest(){
        char[] arr = {4,2,6,1,5,3,'#','#','#','#','#','#','#'};
        TreeNode root = MaxSubtreeTest.initTreeNode(arr);
        System.out.println(root.toString());

        MaxSubtree ms = new MaxSubtree();
        TreeNode node = ms.getMax(root);
        System.out.println(node.val);

    }
}
