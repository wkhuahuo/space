package com.algorithm.swordoffer.run;


/**
 * Created by wkhuahuo on 2017/3/15.
 */
public class TreeUtill {

    public static TreeNode initTree(String[] nums ){


        TreeNode[] nodes = new TreeNode[nums.length];

        for(int i=0;i<nodes.length;i++){
           nodes[i] = new TreeNode(Integer.valueOf(nums[i]));
        }

        for(int i=0;2*i+1<nodes.length;i++){
            nodes[i].left = nodes[2*i+1];
            if(2*i+2<nodes.length) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }



        System.out.print("sucess");
        return nodes[0];
    }
}
