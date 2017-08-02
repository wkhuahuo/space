package com.algorithm.swordoffer.run;

import java.util.ArrayList;
import java.util.Stack;

public class FindPathSum {	
	public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> arrlistArrList = new ArrayList<ArrayList<Integer>>();
		if(root == null|| root.val > target){
			
			return arrlistArrList;
		}
		int sum =0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		findPath(root, target, sum, stack,arrlistArrList);
		
		return arrlistArrList;
	        
	}
	private void findPath(TreeNode root, int target,int sum,Stack<TreeNode> stack,ArrayList<ArrayList<Integer>> arrlistArrList){
		ArrayList<Integer> arrlistInte = new ArrayList<Integer>();
		sum +=root.val; 
		stack.push(root);
		
		boolean isLeaf = (root.left==null)&&(root.right==null);
		if(sum == target && isLeaf){
			for(TreeNode tmpNode : stack){
				arrlistInte.add(tmpNode.val);
			}
			arrlistArrList.add(arrlistInte);
		}
		
		if(root.left!=null){
			findPath(root.left, target, sum, stack, arrlistArrList);
		}
		if(root.right!=null){
			findPath(root.right, target, sum, stack, arrlistArrList);
		}
		stack.pop();
	}
	
	
	//=================================================================================
	
	ArrayList<ArrayList<Integer>> arrlistArrList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> arrlistInte = new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
		if(root == null ){
			return arrlistArrList;
		}
		arrlistInte.add(root.val);
		target -= root.val;
	
		if(target==0  && root.left==null && root.right ==null){
			arrlistArrList.add(new ArrayList<Integer>(arrlistInte));
		}
		
		if(root.left!=null){
			FindPath(root.left, target);
		}
		if(root.right!= null){
			FindPath(root.right, target);
		}
	
		arrlistInte.remove(arrlistInte.size()-1);
		
		return arrlistArrList;
	        
	}
		
}
