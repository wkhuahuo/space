package com.algorithm.leetcode.contest;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
 * changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
    5
  /  \
 2   13

 Output: The root of a Greater Tree like this:
    18
  /   \
 20   13

 *
 * 思路：
 * 1. 按照先右子树在根节点，在左子树的顺序遍历
 * 2. 需要一个变量记录当前节点的和sum[0]。
 * 3. 每个节点的最新的值等于该节点值加上当前sum[0]
 *
 * Created by wkhuahuo on 2017/3/19.
 */
public class Convert_BST_to_Greater_Tree_538 {
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        int[] sum = new int[1];
        sum[0] = 0;
        search(root,sum);
        return root;
    }

    private void search(TreeNode root, int[] sum){
        if(root == null){
            return ;
        }
        search(root.right, sum);

        root.val =root.val+sum[0];
        sum[0] = root.val;

        search(root.left, sum);




    }
}
