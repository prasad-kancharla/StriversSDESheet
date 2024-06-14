package com.prasad.binarysearchtree2;

import java.util.ArrayList;
import java.util.List;

class KthSmallestInBST {

    List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        getList(root);
        return list.get(k + 1);
    }

    private void getList(TreeNode root) {
        if(root == null) {
            return;
        }
        getList(root.left);
        list.add(root.val);
        getList(root.right);
    }

}