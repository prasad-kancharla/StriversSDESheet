package com.prasad.binarytree2;

class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightOfLST = getHeight(root.left);
        int heightOfRST = getHeight(root.right);
        boolean check1 = Math.abs(heightOfRST - heightOfLST) <= 1;
        return isBalanced(root.left) && isBalanced(root.right) && check1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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