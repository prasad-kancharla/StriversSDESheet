package com.prasad.binarytree2;

class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = root.left != null ? maxDepth(root.left) : 0;
        int d2 = root.right != null ? maxDepth(root.right) : 0;
        return Math.max(d1, d2) + 1;
    }

    class TreeNode {

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