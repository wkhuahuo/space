package com.algorithm.batAlgorithm.binarySearch;

/**
 *
 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。

 给定树的根结点root，请返回树的大小。

 * Created by wkhuahuo on 12/01/17.
 */
public class CountNodes {

    public int count(TreeNode root) {
        if(root ==null){
            return 0;
        }
        return binaryTreeNodes(root,1,nodeDeep(root,1));
    }

    public int binaryTreeNodes(TreeNode node,int initlevel,int deep){
        if(initlevel == deep){
            return 1;
        }
        if(nodeDeep(node.right,initlevel+1)+1 == deep){
            return (1<< deep-initlevel-1)+binaryTreeNodes(node.left,initlevel+1,deep);
        }else{
            return (1<< deep-initlevel)+binaryTreeNodes(node.right,initlevel+1,deep);
        }

    }

    public int nodeDeep(TreeNode node, int initlevel){


        while(node!=null){
            node = node.left;
            initlevel++;
        }
        return initlevel-1;
    }



    public int count1(TreeNode root) {
        int leftDeep=0;
        int rightDeep =0;
        TreeNode tmpNode = root;
        while(tmpNode!=null){
            tmpNode = tmpNode.left;
            leftDeep++;
        }
        tmpNode =root;
        if(tmpNode !=null) {
            tmpNode = tmpNode.right;
            while (tmpNode != null) {
                tmpNode = tmpNode.left;
                rightDeep++;
            }
            rightDeep++;
        }

        if(leftDeep-rightDeep==1){
        //    return (int) Math.pow(2,rightDeep-1)+count(root.left);
            return (1 << rightDeep-1)+count(root.left);
        }else if(leftDeep!=0){
         //   return (int) Math.pow(2,leftDeep-1)+count(root.right);
            return (1 <<leftDeep-1)+count(root.right);
        }

        return 0;
    }



}
