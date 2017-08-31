package com.algorithm.lintCode.run;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangkai43
 * @create 2017-08-31-11:44
 * @email wangkai43@meituan.com
 */
public class BinaryTree {
    /**
     * 递归方法
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        int leftDepth =maxDepth(root.left);
        int rightDepth =maxDepth(root.right);

        return leftDepth>rightDepth? leftDepth+1:rightDepth+1;
    }


    /**
     * 非递归方法：层次遍历
     * @param root
     * @return
     */

    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode position = root;
        list.offer(root);
        int nums=1;
        while (!list.isEmpty()){
            TreeNode node = list.poll();
            if(node.left != null){
                list.offer(node.left);
            }
            if(node.right != null){
                list.offer(node.right);
            }
            if(position == node){
                nums++;
                position = list.peekLast();
            }
        }
        return nums;
    }
}
