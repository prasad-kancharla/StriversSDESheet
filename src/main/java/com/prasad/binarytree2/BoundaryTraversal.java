package com.prasad.binarytree2;

import java.util.*;

public class BoundaryTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);
        System.out.println(traverseBoundary(root));
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }
        if (!isLeaf(root)) {
            boundary.add(root.data);
        }
        addLeftViewWithoutLeafNodes(root.left, boundary);
        addLeafNodes(root, boundary);
        addRightViewWithoutLeafNodes(root.right, boundary);
        return boundary;
    }

    private static void addRightViewWithoutLeafNodes(TreeNode root, List<Integer> boundary) {
        Stack<Integer> stack = new Stack<>();
        while (root != null && !isLeaf(root)) {
            stack.push(root.data);
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        while (!stack.isEmpty()) {
            boundary.add(stack.pop());
        }
    }

    private static void addLeafNodes(TreeNode root, List<Integer> boundary) {
        if (root == null) {
            return;
        }
        addLeafNodes(root.left, boundary);
        if (isLeaf(root)) {
            boundary.add(root.data);
        }
        addLeafNodes(root.right, boundary);
    }

    private static void addLeftViewWithoutLeafNodes(TreeNode root, List<Integer> boundary) {
        while (root != null && !isLeaf(root)) {
            boundary.add(root.data);
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private static boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

}