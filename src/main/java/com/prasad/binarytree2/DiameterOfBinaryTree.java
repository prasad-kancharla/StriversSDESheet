package com.prasad.binarytree2;

class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameterOfLST = diameterOfBinaryTree(root.left);
        int diameterOfRST = diameterOfBinaryTree(root.right);
        int ans1 = Math.max(diameterOfLST, diameterOfRST);
        int ans2 = height(root.left) + height(root.right) - 2;
        return Math.max(ans1, ans2);
    }

    public int height(TreeNode treeNode) {
        if (treeNode == null) {
            return -1;
        }
        return Math.max(height(treeNode.right), height(treeNode.left)) + 1;
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