package com.prasad.binarytree;

import java.util.ArrayList;
import java.util.List;

class PostOrderTraversal {

    List<Integer> list;

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList();
        if (root == null) {
            return list;
        }
        getPostorderTraversal(root);
        return list;
    }

    private void getPostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        getPostorderTraversal(root.left);
        getPostorderTraversal(root.right);
        list.add(root.data);
    }

}