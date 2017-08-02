package com.algorithm.batAlgorithm.binaryTree;

/**
 *
 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。

 /**
 以节点node为头的树中，最大的搜索二叉子树只可能来自以下两种情况：
 1.来自node左子树上的最大搜索二叉子树是以node左孩子为头的，并且来自node右子树上的最大搜索二叉子树是以node右孩子为头的
 node左子树上的最大搜索二叉子树的最大值小于node的节点值，node右子树上的最大搜索二叉子树的最小值大于node的节点值
 那么以几点node为头的整棵树都是搜索二叉树。
 2.如果不满足第一种情况，说明以节点node为头的树整体不能连城搜索二叉树，这种情况下，以node为头的树上的最大搜索二叉子树是来自node
 的左子树上的最大搜索二叉子树和来自node的有字数上的最大搜索二叉子树之间，节点数较多的哪个。
 */
/**
 具体步骤如下：
 1.整体过程是二叉树的后续遍历
 2.遍历到当前节点记为cur，先遍历cur的左子树并收集4个信息，分别是左子树上，最大搜索二叉子树的头结点，节点数，树上最小值，树上最大值
 再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头结点，节点数，最小值，最大值
 3.根据步骤2所收集的信息，判断是否满足第一种情况，也就是是否以cur为头的子树，整体都是搜索二叉树，如果满足第一种情况，就返回cur节点
 如果满足第二种情况，就返回左子树和右子树各自的最大搜索二叉树中，节点数较多的哪个树的头结点。
 4.对于如何返回4个信息，可以使用全局变量更新的方式，也可以使用数组的方式
 *
 * Created by wkhuahuo on 16/02/17.
 */
public class MaxSubtree {

    public TreeNode getMax(TreeNode root) {
        int[] info = new int[3];

        TreeNode node =null;//节点
        node =findMaxNode(root,info,node);
        return node;
    }
    private TreeNode findMaxNode(TreeNode root,int[] info, TreeNode node){
        if(root ==null){
            info[0] = 0;//节点数
            info[1] = Integer.MAX_VALUE;//树上最小值
            info[2] = Integer.MIN_VALUE;//树上最大值
            return null;
        }
        int[] tmpLInfo = new int[3];
        TreeNode lNode = findMaxNode(root.left, info, node);
        tmpLInfo[0] = info[0];//节点数
        tmpLInfo[1] = info[1];//最小值
        tmpLInfo[2] = info[2];//最大值

        int[] tmpRInfo = new int[3];
        TreeNode rNode = findMaxNode(root.right,info,node);
        tmpRInfo[0] = info[0];//节点数
        tmpRInfo[1] = info[1];//最小值
        tmpRInfo[2] = info[2];//最大值

        //如果是一个二叉树那么最小值与最大值一定存在于左子树最小值右子树最大值
        info[1] = tmpLInfo[1]>root.val? root.val:tmpLInfo[1];//更新最小值
        info[2] = tmpRInfo[2]<root.val? root.val:tmpRInfo[2];//更新最大值

         if(lNode == root.left && rNode == root.right && tmpLInfo[2]<root.val && tmpRInfo[1]>root.val){
            info[0] = tmpLInfo[0]+tmpRInfo[0]+1;
            node = root;
        }else {
            info[0] = tmpLInfo[0]>tmpRInfo[0]?tmpLInfo[0]:tmpRInfo[0];
            node = tmpLInfo[0]>tmpRInfo[0]? lNode:rNode;
        }

        return node;
    }

}
