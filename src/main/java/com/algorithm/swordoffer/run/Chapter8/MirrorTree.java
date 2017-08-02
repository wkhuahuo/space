package com.algorithm.swordoffer.run.Chapter8;

import com.algorithm.swordoffer.run.TreeNode;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 2017/3/30.
 */
public class MirrorTree {

    public boolean isSymmetrical(TreeNode pRoot) {
        TreeNode treeL = pRoot;
        TreeNode treeR = pRoot;
        return isSymmetricalCore(treeL,treeR);
    }

    private boolean isSymmetricalCore(TreeNode treeL, TreeNode treeR){

        if(treeL ==null && treeR == null){
            return true;
        }
        if(treeL==null || treeR == null){
            return false;
        }
        if(treeL.val != treeR.val){
            return false;
        }


        return isSymmetricalCore(treeL.left,treeR.right)
                && isSymmetricalCore(treeL.right,treeR.left);
    }

    //没通过
    public boolean isSymmetrical1(TreeNode pRoot) {

        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();
        first = inOrderL(pRoot);
        second = inOrderR(pRoot);
        for(int i=0;i<first.size();i++){
            if(!first.get(i).equals(second.get(i))){
                return false;
            }
        }
        return true;
    }
    private ArrayList<String> inOrderL (TreeNode pRoot){
        ArrayList<String> list = new ArrayList<>();
        if(pRoot == null){
            list.add("#");
            return list;
        }
        list.addAll(inOrderL(pRoot.left));
        list.add(pRoot.val+"");
        list.addAll(inOrderL(pRoot.right));
        return list;
    }
    private ArrayList<String> inOrderR(TreeNode pRoot){
        ArrayList<String> list = new ArrayList<>();
        if(pRoot == null){
            list.add("#");
            return list;
        }
        list.addAll(inOrderR(pRoot.right));
        list.add(pRoot.val+"");
        list.addAll(inOrderR(pRoot.left));
        return list;
    }
}
