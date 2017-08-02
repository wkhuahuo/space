package com.wk.batAlgorithm.binaryTree;

import com.wk.swordoffer.test.LinkList;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Sequence;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wkhuahuo on 22/01/17.
 */
public class TreeToSequenceTest {


    public static TreeNode initTreeNode(int[] arr){
        if(arr==null || arr.length<1){
            return null;
        }
        int length = arr.length;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(arr[0]);
        nodeQueue.add(root);
        int index =0;
        while(index<length/2){
            TreeNode treeNode = nodeQueue.poll();

            treeNode.left = new TreeNode(arr[2*index+1]);
            nodeQueue.add(treeNode.left);
            if(2*index+2<length) {
                treeNode.right = new TreeNode(arr[2 * index + 2]);
                nodeQueue.add(treeNode.right);
            }

            index++;
        }
        System.out.println("index= "+index);

        return root;
    }
    public static void seeTree(TreeNode root){
        LinkedList<TreeNode> tmpQueue = new LinkedList<>();
        StringBuffer strbuff = new StringBuffer();
        tmpQueue.offer(root);
        while(!tmpQueue.isEmpty()){
            TreeNode tmpNode = tmpQueue.poll();
            strbuff.append(tmpNode.val+",");
            if(tmpNode.left!=null) {
                tmpQueue.add(tmpNode.left);
            }
            if(tmpNode.right!=null){
                tmpQueue.add(tmpNode.right);
            }

        }
        System.out.println(strbuff.toString());

    }

    @Test
    public void testInitTreeNode(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        TreeNode root = TreeToSequenceTest.initTreeNode(arr);
        System.out.println(root.toString());
        seeTree(root);
        TreeToSequence treeToSequence = new TreeToSequence();
        treeToSequence.convert(root);

    }

}
