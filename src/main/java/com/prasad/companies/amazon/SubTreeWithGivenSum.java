package com.prasad.companies.amazon;

public class SubTreeWithGivenSum {

    public boolean isSubTreeWithGivenSum(TreeNode root, int sum) {
        return checkSubTreeWithGivenSum(root, sum);
    }

    private boolean checkSubTreeWithGivenSum(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (calculateSum(root) == sum) {
            return true;
        }

        return checkSubTreeWithGivenSum(root.left, sum) || checkSubTreeWithGivenSum(root.right, sum);

    }

    private int calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + calculateSum(root.left) + calculateSum(root.right);
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


