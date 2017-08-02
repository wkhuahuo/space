package com.algorithm.leetcode.contest;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
     1
    / \
   2   3
  / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 * Created by wkhuahuo on 2017/3/19.
 */
public class Diameter_of_Binary_Tree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] maxLength = new int[1];
        lengthpath(root,maxLength);

        return maxLength[0]-1;
    }
    private int lengthpath(TreeNode root, int[] maxLength){
        if(root == null){
            return 0;
        }

        int left = lengthpath(root.left,maxLength);
        int right = lengthpath(root.right,maxLength);
        int tmpL = left+right+1;
        maxLength[0] = tmpL>maxLength[0]?tmpL:maxLength[0];
        return left>right?left+1:right+1;
    }

}
