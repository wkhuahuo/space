package com.algorithm.swordoffer.run.chapter6;

import com.algorithm.swordoffer.run.TreeNode;

/**
 * Created by wkhuahuo on 2017/3/27.
 */
public class BlanceTree_39_1 {
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] foo = new boolean[1];
        foo[0] =true;
        isBalanced(root,foo);
        return foo[0];
    }
    private int isBalanced(TreeNode root,boolean[] foo){
        if(root == null){
            return 0;
        }
        int left = isBalanced(root.left,foo);
        int right = isBalanced(root.right,foo);
        if(right - left>1 || right-left<-1){
            foo[0] = false;
        }
        return left > right ? left+1: right+1;
    }
}
