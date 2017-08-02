package com.algorithm.batAlgorithm.binaryTree;

/**
 * Created by wkhuahuo on 13/02/17.
 */
public class CheckBalance {
    public boolean check(TreeNode root) {
        boolean[] result = new boolean[1];
        result[0] =true;
        getHeight(root,0,result);

        return result[0];
    }

    private int getHeight(TreeNode root, int level,boolean[] result){
        if(root==null){
            return level;
        }
        int left = getHeight(root.left,level+1,result);
        if(!result[0]){
            return level;
        }
        int right = getHeight(root.right,level+1,result);
        if(!result[0]){
            return level;
        }
        if(Math.abs(left-right)>1){
            result[0] = false;
        }

        return Math.max(left,right);
    }
}
