package com.algorithm.batAlgorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕;
 * 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 测试样例：
 * Created by wkhuahuo on 14/02/17.
 */
public class FoldPaper {

    public String[] foldPaper(int n) {
        ArrayList<String> nodes = new ArrayList<>();
        fold(1,n,true,nodes);
        String[] strs = new String[nodes.size()];
        nodes.toArray(strs);
        return strs;
    }
    private void fold(int i,int N,boolean isdown,ArrayList<String> arrlist){
        if(i>N) return ;
        fold(i+1,N,true,arrlist);
        arrlist.add(isdown? "down":"up");
        fold(i+1,N,false,arrlist);

    }


    public String[] foldPaper2(int n) {
        int nums = (int)Math.pow(2,n)-1;
        TreeNode root = initTree(nums);
        ArrayList<String> nodes = postOrder(root);
        String[] strs = new String[nodes.size()];
        nodes.toArray(strs);
        return strs;
    }

    private TreeNode initTree(int nums){
        int[] results = new int[nums];
        results[0] = 0;//down
        LinkedList<TreeNode> nodes= new LinkedList<>();

        TreeNode root = new TreeNode(0);
        TreeNode tmpnode = root;
        nodes.offer(root);
        for(int i=1;i<results.length;i++){
            if(i%2==1){
                results[i] = 0;//down
            }else{
                results[i] = 1;//up
            }
        }
        for(int i = 0;i<results.length/2;i++){
            tmpnode = nodes.poll();
            tmpnode.left = new TreeNode(results[2*i+1]);
            nodes.offer(tmpnode.left);
            if(2*i+2<results.length) {
                tmpnode.right = new TreeNode(results[2*i+2]);
                nodes.offer(tmpnode.right);
            }
        }

        return root;
    }
    private ArrayList<String> postOrder(TreeNode root){
        ArrayList<String> nodeList = new ArrayList<String>();
        if(root == null){
            return nodeList;
        }

        nodeList.addAll(postOrder(root.left));

        if(root.val == 0) {
            nodeList.add("down");
        }else  if(root.val == 1){
            nodeList.add("up");
        }

        nodeList.addAll(postOrder(root.right));
        return nodeList;
    }
}
