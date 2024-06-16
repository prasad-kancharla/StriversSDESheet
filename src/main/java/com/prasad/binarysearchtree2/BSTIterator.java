package com.prasad.binarysearchtree2;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    private final List<Integer> list;
    private int i = -1;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) i = 0;
        fillList(root);
    }

    private void fillList(TreeNode root) {
        if (root == null) {
            return;
        }
        fillList(root.left);
        list.add(root.val);
        fillList(root.right);
    }

    public int next() {
        int ans = list.get(i);
        i++;
        return ans;
    }
    
    public boolean hasNext() {
        return i < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */