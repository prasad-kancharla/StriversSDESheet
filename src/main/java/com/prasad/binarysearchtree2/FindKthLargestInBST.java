package com.prasad.binarysearchtree2;

class FindKthLargestInBST {

    int ans;
    int count;

    public int kthLargest(Node root, int K) {
        ans = -1;
        count = 0;
        getKthLargest(root, K);
        return ans;
    }

    private void getKthLargest(Node root, int k) {
        if (root == null || ans != -1) {
            return;
        }
        getKthLargest(root.right, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }
        getKthLargest(root.left, k);
    }

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

}