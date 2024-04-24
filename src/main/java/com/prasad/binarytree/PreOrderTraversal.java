package com.prasad.binarytree;

import java.util.ArrayList;
import java.util.List;

class PreOrderTraversal {

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

    static List<Integer> list;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorder(root);
        return list;
    }

    private void preorder(TreeNode root){
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }

}