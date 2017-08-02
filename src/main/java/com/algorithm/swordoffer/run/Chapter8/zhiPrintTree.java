package com.algorithm.swordoffer.run.Chapter8;

import com.algorithm.swordoffer.run.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by wkhuahuo on 2017/3/31.
 */
public class zhiPrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        return myPrint(pRoot);
    }
    private ArrayList<ArrayList<Integer>> myPrint(TreeNode root){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> hang = new ArrayList<>();

        LinkedList<TreeNode> sequence = new LinkedList<>();
        TreeNode tailNode = root;

        TreeNode tmpNode = null;
        sequence.add(root);

        boolean foo=true;
        while(!sequence.isEmpty()){
            tmpNode = sequence.poll();

            hang.add(root.val);

            if(tailNode == tmpNode){
                if(tailNode.right!=null){
                    tailNode = tailNode.right;
                }else if(tailNode.left != null){
                    tailNode = tmpNode.left;
                }else {
                    tailNode = sequence.getLast();
                }
                myadd(result,hang,foo);
                hang.clear();
                if(foo) {
                    foo = false;
                }else {
                    foo = true;
                }
            }
            if(tmpNode.left != null) {
                sequence.add(tmpNode.left);
                hang.add(tmpNode.left.val);
            }
            if(tmpNode.right !=null) {
                sequence.add(tmpNode.right);
                hang.add(tmpNode.right.val);
            }
            if(tailNode.left == null &&tailNode.right == null){
                tailNode = sequence.getLast();
            }
        }
        return result;
    }

    private void myadd(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> hang, boolean foo){
        if(foo) {
            result.add(hang);
        }else{
            ArrayList<Integer>tmp = new ArrayList<>();
            for(int i=hang.size()-1;i>=0;i--){
                tmp.add(hang.get(i));
            }
            result.add(tmp);
        }
    }
}
