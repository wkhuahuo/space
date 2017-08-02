package com.algorithm.swordoffer.run.chapter6;

import com.algorithm.swordoffer.run.TreeNode;

/**
 * Created by wkhuahuo on 2017/3/27.
 */
public class TreeDepth_39 {
    public int TreeDepth(TreeNode root) {
        return getDepth(root);
    }
    private int getDepth(TreeNode root){
        int depth=0;
        if(root ==null){
            return depth;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        depth = left>right? left: right;
        return depth+1;
    }
}
