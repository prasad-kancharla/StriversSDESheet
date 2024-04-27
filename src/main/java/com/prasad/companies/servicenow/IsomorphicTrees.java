package com.prasad.companies.servicenow;

public class IsomorphicTrees {

    public static boolean checkTree(BinaryTreeNode<Integer> tree1, BinaryTreeNode<Integer> tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.data != tree2.data) {
            return false;
        }
        return (checkTree(tree1.left, tree2.left) && checkTree(tree1.right, tree2.right)) ||
                (checkTree(tree1.left, tree2.right) && checkTree(tree1.right, tree2.left));
    }

    class BinaryTreeNode<Integer> {

        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }

    }

}
