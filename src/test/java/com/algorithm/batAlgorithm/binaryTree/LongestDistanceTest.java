package com.algorithm.batAlgorithm.binaryTree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by wkhuahuo on 15/02/17.
 */
public class LongestDistanceTest {

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
    public void findLongestTest(){
        char[] arr = {9,5,'#',4,7,2,'#',6,8,1,3,'#','#','#','#','#','#','#','#'};
        TreeNode root = LongestDistanceTest.initTreeNode(arr);
        System.out.println(root.toString());
        seeTree(root);

        LongestDistance l = new LongestDistance();
        int distance=l.findLongest(root);
        System.out.println(distance);
    }
}
