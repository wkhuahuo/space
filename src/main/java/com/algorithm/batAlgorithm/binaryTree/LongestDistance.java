package com.algorithm.batAlgorithm.binaryTree;

/**
 * Created by wkhuahuo on 15/02/17.
 */
public class LongestDistance {

    public int findLongest(TreeNode root) {

        int[] distance = new int[3];
        postOrder3(root,distance);

        return distance[2];
    }

    private void postOrder3(TreeNode root,int[] distance){

        if(root == null){
            return ;
        }
        int maxL = 0, maxR = 0;
        int maxdis=0;
        if(root.left!=null) {
            postOrder3(root.left,distance);
            maxL = distance[0]>distance[1]? ++distance[0]:++distance[1];
            maxdis = distance[2];
        }

        if(root.right!=null) {
            postOrder3(root.right,distance);
            maxR = distance[0]>distance[1]? ++distance[0]:++distance[1];
            maxdis = distance[2]>maxdis?distance[2]:maxdis;
        }

        distance[0] = maxL;
        distance[1] = maxR;
        int tmpdis = maxL>maxR?maxL:maxR;
        distance[2] = maxdis>maxL+maxR+1?maxdis:maxL+maxR+1;

    }



    public int findLongest3(TreeNode root) {

        int[] distance = new int[3];
        distance = postOrder2(root);

        return distance[2];
    }

    private int[] postOrder2(TreeNode root){
        int[] distance = new int[3];
        if(root == null){
            return distance;
        }
        int maxL = 0, maxR = 0;
        int maxdis=0;
        if(root.left!=null) {
            distance = postOrder2(root.left);
            maxL = distance[0]>distance[1]? ++distance[0]:++distance[1];
            maxdis = distance[2];
        }

        if(root.right!=null) {
            distance = postOrder2(root.right);
            maxR = distance[0]>distance[1]? ++distance[0]:++distance[1];
            maxdis = distance[2]>maxdis?distance[2]:maxdis;
        }

        distance[0] = maxL;
        distance[1] = maxR;
        int tmpdis = maxL>maxR?maxL:maxR;
        distance[2] = maxdis>maxL+maxR+1?maxdis:maxL+maxR+1;
        return distance;
    }

    public int findLongest2(TreeNode root) {

        int[] distance = new int[3];
        distance = postOrder1(root);

        return distance[2];
    }

    private int[] postOrder1(TreeNode root){
        int[] distance = new int[3];
        if(root == null){
            return distance;
        }

        int maxL = 0, maxR = 0;
        int maxdis=0;
        int[] tmpLdistance = null;
        if(root.left!=null) {
            tmpLdistance = postOrder1(root.left);
            maxL = tmpLdistance[0]>tmpLdistance[1]? ++tmpLdistance[0]:++tmpLdistance[1];
            maxdis = tmpLdistance[2];
        }
        int[] tmpRdistance = null;
        if(root.right!=null) {
            tmpRdistance = postOrder1(root.right);
            maxR = tmpRdistance[0]>tmpRdistance[1]? ++tmpRdistance[0]:++tmpRdistance[1];
            maxdis = tmpRdistance[2]>maxdis?tmpRdistance[2]:maxdis;
        }

        distance[0] += maxL;
        distance[1] += maxR;
        int tmpdis = maxL>maxR?maxL:maxR;
        distance[2] = maxdis>maxL+maxR+1?maxdis:maxL+maxR+1;
        return distance;
    }

    public int findLongest1(TreeNode root) {
        // write code here
        int[] lr = new int[2];
        int[] distance = new int[3];
        distance = postOrder(root);

        return distance[2];
    }

    private int[] postOrder(TreeNode root){
        int[] distance = new int[3];
        if(root == null){
            return distance;
        }
        int[] tmpLdistance = null;
        if(root.left!=null) {
            tmpLdistance = postOrder(root.left);
            if(tmpLdistance[0]>tmpLdistance[1]){
                tmpLdistance[0]++;
            }else{
                tmpLdistance[1]++;
            }
        }
        int[] tmpRdistance = null;
        if(root.right!=null) {
            tmpRdistance = postOrder(root.right);
            if(tmpRdistance[0]>tmpRdistance[1]) {
                tmpRdistance[0]++;
            }else {
                tmpRdistance[1]++;
            }
        }

        int maxL = 0, maxR = 0;
        int maxdis=0;
        if(tmpLdistance != null){
            maxL = tmpLdistance[0] >tmpLdistance[1]?tmpLdistance[0]:tmpLdistance[1];
            maxdis = tmpLdistance[2];
        }
        if(tmpRdistance != null) {
            maxR = tmpRdistance[0] > tmpRdistance[1] ? tmpRdistance[0] : tmpRdistance[1];
            maxdis = tmpRdistance[2]>maxdis?tmpRdistance[2]:maxdis;
        }
        distance[0] += maxL;
        distance[1] += maxR;
        int tmpdis = maxL>maxR?maxL:maxR;
        distance[2] = maxdis>maxL+maxR+1?maxdis:maxL+maxR+1;
       return distance;

    }
}
