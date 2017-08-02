package com.algorithm.batAlgorithm.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 * Created by wkhuahuo on 14/02/17.
 */
public class FindErrorNode {

    public int[] findError(TreeNode root) {

        return searchError(root);
    }
    private int[] searchError(TreeNode root){//非递归实现
        if(root == null){
            return null ;
        }
        TreeNode[] errNodes = new TreeNode[2];
        int[] errvals = new int[2];
        TreeNode point = null;

        Stack<TreeNode> nodesStack = new Stack<>();
        TreeNode tmpNode = root;
        while (nodesStack.size()>0 || tmpNode!=null){
            while(tmpNode!=null){
                nodesStack.push(tmpNode);
                tmpNode = tmpNode.left;
            }
            tmpNode = nodesStack.pop();

            if(point!=null&&point.val>tmpNode.val)
            {
                errNodes[0]= errNodes[0]==null?point:errNodes[0];
                errNodes[1]=tmpNode;
            }
            point=tmpNode;

            tmpNode = tmpNode.right;

        }
        errvals[0] = errNodes[1].val;
        errvals[1] = errNodes[0].val;
        return errvals;
    }


    public int[] findError2(TreeNode root) {

        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist = inorder(root);
        Integer[] arrint = new Integer[arrlist.size()];
        arrlist.toArray(arrint);
        int[] result = {-1,-1};
        int index =0;
        for(int i=0;i<arrint.length-1;i++){
            if(arrint[i]>arrint[i+1] && index ==0){
                result[index++] = i;
            }else if(arrint[i]>arrint[i+1] && index ==1){
                result[index++] = i+1;
            }

        }
        if(index == 1){
            result[index] = result[index-1]+1;
        }
        result[0] = arrint[result[0]];
        result[1] = arrint[result[1]];
        if(result[0]>result[1]){
            int tmp = result[1];
            result[1] = result[0];
            result[0] = tmp;
        }
        return result;
    }
    private ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> arrlist = new ArrayList<>();
        if(root == null){
            return arrlist;
        }
        arrlist.addAll(inorder(root.left));
        arrlist.add(root.val);
        arrlist.addAll(inorder(root.right));

        return arrlist;
    }
}
