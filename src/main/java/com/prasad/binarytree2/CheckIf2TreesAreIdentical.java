package com.prasad.binarytree2;

class CheckIf2TreesAreIdentical {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null & q != null) || (p != null & q == null)) {
            return false;
        }
        if (p != null && q != null && p.val != q.val) {
            return false;
        }
        boolean check1 = isSameTree(p.left, q.left);
        boolean check2 = isSameTree(p.right, q.right);
        return check1 & check2;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}