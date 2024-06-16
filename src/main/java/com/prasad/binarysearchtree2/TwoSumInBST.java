package com.prasad.binarysearchtree2;

import java.util.HashSet;

class TwoSumInBST {

    HashSet<Integer> hashSet = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (hashSet.contains(k - root.val)) {
            return true;
        }
        hashSet.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}