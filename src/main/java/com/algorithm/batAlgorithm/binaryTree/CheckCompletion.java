package com.algorithm.batAlgorithm.binaryTree;

import java.util.LinkedList;

/**
 *

 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 * Created by wkhuahuo on 13/02/17.
 */
public class CheckCompletion {

    public boolean chk(TreeNode root) {

        LinkedList<TreeNode> sequence = new LinkedList<>();
        TreeNode tmpNode = null;

        boolean isleaf = false;
        sequence.offer(root);

        while(sequence.size()>0){
            tmpNode = sequence.poll();
            if(tmpNode.left==null && tmpNode.right!=null){
                return false;
            }
            if(!isleaf && tmpNode.left != null && tmpNode.right != null){
                sequence.offer(tmpNode.left);
                sequence.offer(tmpNode.right);
            }else if(!isleaf && tmpNode.left !=null && tmpNode.right !=null){
                sequence.offer(tmpNode.left);
                isleaf = true;
            }else if (isleaf){
                if(tmpNode.left !=null || tmpNode.right != null){
                    return false;
                }
            }


        }
        return true;
    }



}
