package com.algorithm.swordoffer.run;

public class BinaryTree {
	/*
	 * 方法一：	时间：208ms
	 * 			空间：4997k
	 */
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//		pre = {1,2,4,7,3,5,6,8};
//		in =  {4,7,2,1,5,3,8,6};
		if(pre==null || in == null ||pre.length==0||in.length==0){
			return null;
		}
		TreeNode treeNode= null;
		int inLeft=0;
		int inRight=in.length-1;
		int preRoot =pre[0];
		treeNode = reConstructBinaryTreeCore(inLeft,inRight,pre,in,0);
		return treeNode;
	        
	}
	private TreeNode reConstructBinaryTreeCore(int inLeft,int inRight,int[] pre, int[] in,int preRootIndex){
		TreeNode tmpNode = new TreeNode(pre[preRootIndex]);
		
		int inRootIndex = findRootInPre(in,pre,preRootIndex);
		int step = inRootIndex-inLeft; //step=3
		
		if(inRootIndex>inLeft && inLeft<=inRight){
			int tmpInRight = inRootIndex-1;
			tmpNode.left = reConstructBinaryTreeCore(inLeft,tmpInRight,pre,in,preRootIndex+1);
		}
		if(inRootIndex<inRight && inLeft<=inRight){
			int tmpInLeft = inRootIndex+1;
			tmpNode.right = reConstructBinaryTreeCore(tmpInLeft,inRight,pre,in,preRootIndex+step+1);
		}
		
		return tmpNode;
		
	}
	private int findRootInPre(int [] in,int [] pre,int preRootIndex){
		int index=0;
		for(int iIn=0; iIn < in.length; iIn++){
			if(pre[preRootIndex]==in[iIn]){
				index = iIn;
				break;
			}
		}
		return index;
	}
	/*
	 * 方法二： 	时间:165ms
	 * 			空间：5075k
	 */
	
	public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
    	if(pre==null||in==null){
    		return null;
     	}
    	java.util.HashMap<Integer,Integer> map= new java.util.HashMap<Integer, Integer>();
		for(int i=0;i<in.length;i++){
			map.put(in[i],i);
		}
		return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
	}

	public TreeNode preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,java.util.HashMap<Integer,Integer> map){
		if(pi>pj){
			return null;
		}
		TreeNode head=new TreeNode(p[pi]);
		int index=map.get(p[pi]);
		head.left=preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
		head.right=preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
		return head;
	}
	
	
}
