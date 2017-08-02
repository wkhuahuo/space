package com.algorithm.batAlgorithm.binarySearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wkhuahuo on 12/01/17.
 */
public class MyUtil {


    public static TreeNode initCompleteBinaryTree(int[] arr){
        TreeNode[] treenodearr= new TreeNode[arr.length];
        for (int i=0;i<treenodearr.length;i++){
            treenodearr[i] = new TreeNode(arr[i]);
        }

        int length = treenodearr.length-1;
        int maxi = (length-1)/2;
        for(int i=0;i<=maxi;i++){
            treenodearr[i].left = treenodearr[2*i+1];
            treenodearr[i].right = treenodearr[2*i+2];
        }
        return treenodearr[0];
    }

    public static String myString(TreeNode root){

        if(root ==null){
            return null;
        }
        StringBuilder strb = new StringBuilder();
        Queue<TreeNode> treequeue = new LinkedList<>();
        treequeue.add(root);
        strb.append("< ");
        int now = 1;
        int next =0;
        while(!treequeue.isEmpty()){
            TreeNode tmp = treequeue.poll();
            strb.append(tmp.val+" ");
            now--;


            if(tmp.left!=null){
                treequeue.offer(tmp.left);
                next++;
            }
            if(tmp.right !=null){

                treequeue.offer(tmp.right);
                next++;
            }

            if(now==0){
                now = next;
                next = 0;
                strb.append(";");
            }
        }
        strb.append(">");


        return strb.toString();
    }
}
