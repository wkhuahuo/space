package com.algorithm.swordoffer.test.Chapter8;

import com.algorithm.swordoffer.run.Chapter8.zhiPrintTree;
import com.algorithm.swordoffer.run.TreeNode;

/**
 * Created by wkhuahuo on 2017/3/31.
 */
public class zhiPrintTreeTest {
    public static void main(String[] args){
        zhiPrintTree zhi = new zhiPrintTree();

        int[] arr ={1,2,3,4,5,6,7,8,9};

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
        zhi.Print(nodes[0]);
    }
}
