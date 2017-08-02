package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/3.
 */
public class IdenticalTree {

    public boolean chkIdentical(TreeNode A, TreeNode B) {

        /*if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val ) {
            if(chkIdentical(A.left, B.left) && chkIdentical(A.right, B.right)){
                return true;
            }
        }
        return chkIdentical(A.left, B) || chkIdentical(A.right, B);
*/
        TreeNode from = A;
        boolean al = false;
        boolean ar = false;

        boolean a = checkTrue(from,B);

        if(from.left!=null)
        al = chkIdentical(from.left,B);
        if(from.right!=null)
        ar = chkIdentical(from.right,B);
        return a||al||ar;
    }

    private boolean checkTrue(TreeNode from, TreeNode b) {
        if(from == null && b == null){
            return true;
        }
        if(from == null || b== null){
            return false;
        }
        if(from.val == b.val){
            return checkTrue(from.left,b.left) && checkTrue(from.right, b.right);
        }else{
            return false;
        }
    }
    ///++++mahao++++++++++++++++//
    public static boolean isSubTree(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null) return false;

        if(A.val == B.val && isMatch(A, B)) return true;

        return isSubTree(A.left, B) || isSubTree(A.right, B);
    }

    private static boolean isMatch(TreeNode A, TreeNode B) {
        if(A== null && B == null) return true;
        if(A == null || B == null) return false;
        if(A.val != B.val) return false;

        return isMatch(A.left, B.left) && isMatch(A.right, B.right);
    }

    public boolean chkIdenticalInString(TreeNode A, TreeNode B) {

        return false;

    }
    private String treeToString(TreeNode A){
        StringBuilder strbuilder = new StringBuilder();

        if(A != null){
            strbuilder.append(A.val);

        }else {
            strbuilder.append("#");
        }
        return null;
    }

}

