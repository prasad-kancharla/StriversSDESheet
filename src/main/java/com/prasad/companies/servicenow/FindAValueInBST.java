package com.prasad.companies.servicenow;

public class FindAValueInBST {

    public static boolean findNode(TreeNode<Integer> root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;
        if (root.data > key) return findNode(root.left, key);
        return findNode(root.right, key);
    }

}