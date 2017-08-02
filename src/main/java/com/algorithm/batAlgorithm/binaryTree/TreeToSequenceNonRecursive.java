package com.algorithm.batAlgorithm.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wkhuahuo on 22/01/17.
 */
public class TreeToSequenceNonRecursive {

    public int[][] convert(TreeNode root) {
        int[][] result = new int[3][];
        result[0] = translate(preOrder(root));
           myprint(result[0]);
        result[1] = translate(inOrder(root));
          myprint(result[1]);
        result[2] = translate(postOrder(root));
            myprint(result[2]);
        return result;
    }
    private int[] translate(ArrayList<Integer> arrlist){
        int[] preOrder = new int[arrlist.size()];
        for(int i=0;i<arrlist.size();i++){
            preOrder[i] = arrlist.get(i);
        }
        return preOrder;
    }

    private ArrayList<Integer> preOrder(TreeNode root){
        if(root ==null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        tmpStack.add(root);
        while(tmpStack.size()>0){
            TreeNode tmpNode = tmpStack.pop();
            arr.add(tmpNode.val);
            if(tmpNode.right!=null){
                tmpStack.push(tmpNode.right);
            }
            if(tmpNode.left!=null){
                tmpStack.push(tmpNode.left);
            }
        }

        return arr;
    }

    /**
     * 非递归中序遍历
     * @param root
     * @return
     */
    private ArrayList<Integer>  inOrder(TreeNode root){
        if(root ==null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        TreeNode tmpNode = root;

        while(tmpStack.size()>0 || tmpNode!=null) {

            while (tmpNode!= null ) {
                tmpStack.push(tmpNode);
                tmpNode = tmpNode.left;
            }
            tmpNode = tmpStack.pop();
            arr.add(tmpNode.val);
            tmpNode = tmpNode.right;

        }

        return arr;
    }

    /**
     * 后序遍历非递归实现
     * @param root
     * @return
     */
    private ArrayList<Integer>  postOrder(TreeNode root){
        if(root ==null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();

        TreeNode tmpNode = root;
        tmpStack.push(root);
        while(tmpStack.size()>0){
            tmpNode = tmpStack.pop();
            resultStack.push(tmpNode);
            if(tmpNode.left!=null) {
                tmpStack.push(tmpNode.left);
            }
            if(tmpNode.right!=null) {
                tmpStack.push(tmpNode.right);
            }

        }
        while (resultStack.size()>0){
            arr.add(resultStack.pop().val);
        }
        return arr;
    }

    private  void myprint(int[] arr){
        for(int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
