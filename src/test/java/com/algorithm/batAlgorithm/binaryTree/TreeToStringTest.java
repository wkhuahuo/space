package com.wk.batAlgorithm.binaryTree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by wkhuahuo on 11/02/17.
 */
public class TreeToStringTest {
    public static TreeNode initTreeNode(int[] arr){
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

            treeNode.left = new TreeNode(arr[2*index+1]);
            nodeQueue.add(treeNode.left);
            if(2*index+2<length) {
                treeNode.right = new TreeNode(arr[2 * index + 2]);
                nodeQueue.add(treeNode.right);
            }

            index++;
        }
        System.out.println("index= "+index);

        return root;
    }

    public static void seeTree(TreeNode root){
        LinkedList<TreeNode> tmpQueue = new LinkedList<>();
        StringBuffer strbuff = new StringBuffer();
        tmpQueue.offer(root);
        while(!tmpQueue.isEmpty()){
            TreeNode tmpNode = tmpQueue.poll();
            strbuff.append(tmpNode.val+",");
            if(tmpNode.left!=null) {
                tmpQueue.add(tmpNode.left);
            }
            if(tmpNode.right!=null){
                tmpQueue.add(tmpNode.right);
            }

        }
        System.out.println(strbuff.toString());

    }

    @Test
    public void toStringTest(){
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root = TreeToSequenceTest.initTreeNode(arr);
        System.out.println(root.toString());
        seeTree(root);

        TreeToString treetoS = new TreeToString();
        String str = treetoS.toString(root);
        System.out.println(str);
    }
}
