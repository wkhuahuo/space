package com.algorithm.batAlgorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * Created by wkhuahuo on 04/02/17.
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        if (root==null){
            return null;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        treeNodeQueue.add(root);
        TreeNode lastNode = root;
        TreeNode newLast = root;
        ArrayList<Integer> line = new ArrayList<>();
        while(treeNodeQueue.size()!=0){
            TreeNode tmpNode = treeNodeQueue.poll();
            if(tmpNode.left!= null) {
                treeNodeQueue.offer(tmpNode.left);
                newLast = tmpNode.left;
            }
            if(tmpNode.right!= null) {
                treeNodeQueue.offer(tmpNode.right);
                newLast = tmpNode.right;
            }
            line.add(tmpNode.val);
            if(tmpNode == lastNode){
                lastNode = newLast;
                lines.add(line);
                line = new ArrayList<>();
                System.out.println();
            }
        }
        return toDArray(lines);
    }


    private  int[][] toDArray(ArrayList<ArrayList<Integer>> lines){
        int lineNum = lines.size();
        int[][] results = new int[lineNum][];
        System.out.println("size= "+results.length);
        for(ArrayList<Integer> l:lines){
            System.out.println("<"+l.toString()+">");
        }
        for(int i=0;i<results.length;i++){
            ArrayList<Integer> line =lines.get(i);
            System.out.println("+=+=+"+line.toString());
            System.out.println("line= "+line.size());
            results[i] = new int[line.size()];
            for(int j=0;j<results[i].length;j++){
                results[i][j] = line.get(j);
            }
            System.out.println("num= "+results[i].length);
        }
        return results;
    }
}
