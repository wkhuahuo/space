package com.algorithm.swordoffer.run;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintTree {
	
	//41ms 654k
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		if(root==null){
			return arrlist;
		}
		Queue<TreeNode> qAD = new ArrayDeque<TreeNode>();
		qAD.add(root);
		TreeNode tmpTN = null;
		while(!qAD.isEmpty()){
			tmpTN = qAD.poll();
			arrlist.add(tmpTN.val);
			if(tmpTN.left!=null){
				qAD.add(tmpTN.left);
			}
			if(tmpTN.right!=null){
				qAD.add(tmpTN.right);
			}
		}
		return arrlist;
        
    }
	
	public ArrayList<Integer> RecursionPrint(TreeNode root) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		if(root==null){
			return arrlist;
		}
		arrlist.add(root.val);
		arrlist.addAll(PrintFromTopToBottom(root.left));
		arrlist.addAll(PrintFromTopToBottom(root.right));
		return arrlist;
        
    }
	
	
	
	
}
