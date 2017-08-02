package com.algorithm.batAlgorithm.binaryTree;

import java.util.ArrayList;

/**
 * Created by wkhuahuo on 22/01/17.
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] result = new int[3][];

        result[0] = translate(preOrder(root));
     //   myprint(result[0]);
        result[1] = translate(inOrder(root));
      //  myprint(result[1]);
        result[2] = translate(postOrder(root));
    //    myprint(result[2]);

        return result;
    }
    private int[] translate(ArrayList<Integer> arrlist){
        int[] preOrder = new int[arrlist.size()];
        for(int i=0;i<arrlist.size();i++){
            preOrder[i] = arrlist.get(i);
        }
        return preOrder;
    }

    private ArrayList<Integer> preOrder(TreeNode root){
        if(root ==null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        ArrayList<Integer> tmpL =preOrder(root.left);
        if(tmpL!=null){
            arr.addAll(tmpL);
        }
        ArrayList<Integer> tmpR = preOrder(root.right);
        if(tmpR!=null){
            arr.addAll(tmpR);
        }
        return arr;
    }

    private ArrayList<Integer>  inOrder(TreeNode root){
        if(root ==null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();

        ArrayList<Integer> tmpL =inOrder(root.left);
        if(tmpL!=null){
            arr.addAll(tmpL);
        }
        arr.add(root.val);
        ArrayList<Integer> tmpR = inOrder(root.right);
        if(tmpR!=null){
            arr.addAll(tmpR);
        }
        return arr;
    }

    private ArrayList<Integer>  postOrder(TreeNode root){
        if(root ==null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();

        ArrayList<Integer> tmpL =postOrder(root.left);
        if(tmpL!=null){
            arr.addAll(tmpL);
        }
        ArrayList<Integer> tmpR = postOrder(root.right);
        if(tmpR!=null){
            arr.addAll(tmpR);
        }
        arr.add(root.val);

        return arr;
    }

    private  void myprint(int[] arr){
        for(int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
