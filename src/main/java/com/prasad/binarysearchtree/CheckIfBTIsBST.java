package com.prasad.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

class CheckIfBTIsBST {

    static List<Integer> inOrder;

    public boolean isValidBST(TreeNode root) {
        inOrder = new ArrayList();
        getInOrder(root);
        int n = inOrder.size();
        int prev = inOrder.get(0);
        for (int i = 1; i < n; i++) {
            if (prev >= inOrder.get(i)) {
                return false;
            }
            prev = inOrder.get(i);
        }
        return true;
    }

    public void getInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        getInOrder(root.left);
        inOrder.add(root.val);
        getInOrder(root.right);
    }

}