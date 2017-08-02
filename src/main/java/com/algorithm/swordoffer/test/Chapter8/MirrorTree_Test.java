package com.algorithm.swordoffer.test.Chapter8;

import com.algorithm.swordoffer.run.Chapter8.MirrorTree;
import com.algorithm.swordoffer.run.TreeNode;

/**
 * Created by wkhuahuo on 2017/3/31.
 */
public class MirrorTree_Test {
    public static void main(String[] args){
        MirrorTree mirror = new MirrorTree();
        int[] arr ={6,6,6,6,8,8,6,6,8,6,8};

        TreeNode[] nodes = new TreeNode[arr.length];
        for(int i=0;i<arr.length;i++){

            nodes[i] = new TreeNode(arr[i]);
        }
        int index=0;
        while(index<(nodes.length-1)/2){
            nodes[index].left = nodes[2*index+1];
            if(2*index+1<nodes.length){
                nodes[index].right = nodes[2*index+2];
            }
            index++;
        }

        mirror.isSymmetrical(nodes[0]);

    }
}
