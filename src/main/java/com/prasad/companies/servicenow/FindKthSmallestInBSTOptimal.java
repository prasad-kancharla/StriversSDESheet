package com.prasad.companies.servicenow;

class FindKthSmallestInBSTOptimal {

    static int count;
    static int ans;

    public int kthSmallest(TreeNode<Integer> root, int k) {
        count = 0;
        ans = -1;
        if (root == null) {
            return -1;
        }
        inOrderTraversal(root, k);
        return ans;
    }

    private void inOrderTraversal(TreeNode<Integer> root, int k) {
        if (root == null || ans != -1) {
            return;
        }

        inOrderTraversal(root.left, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }

        inOrderTraversal(root.right, k);
    }

}