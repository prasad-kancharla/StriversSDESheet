package com.prasad.binarysearchtree2;

class KthSmallestInBSTOptimal {

    int count;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        count = 0;
        getAns(root, k);
        return ans;
    }

    private void getAns(TreeNode root, int k) {
        if (root == null || ans != -1) {
            return;
        }
        getAns(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        getAns(root.right, k);
    }

}