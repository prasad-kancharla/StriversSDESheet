package com.prasad.binarysearchtree2;

public class FloorInBST {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(3);
        //        root.left.left = new TreeNode<>(2);
        //        root.left.right = new TreeNode<>(6);
        System.out.println(floorInBST(root, 2));

    }

    static int floor;

    public static int floorInBST(TreeNode<Integer> root, int X) {
        floor = -1;
        getFloor(root, X);
        return floor;
    }

    public static void getFloor(TreeNode<Integer> root, int X) {
        if (root == null) {
            return;
        }
        if (root.data > X) {
            getFloor(root.left, X);
        } else {
            if (root.data > floor) {
                floor = root.data;
            }
            getFloor(root.right, X);
        }
    }

    static class TreeNode<T> {

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

}