package com.prasad.binarysearchtree2;


public class CeilInBst {

    static int ceil;
    public static int findCeil(TreeNode<Integer> node, int x) {
        ceil = -1;
        getCeil(node, x);
        return ceil;
    }

    private static void getCeil(TreeNode<Integer> node, int x) {
        if (node == null) return;

        if (node.data < x) {
            getCeil(node.right, x);
        } else {
            if (node.data >= x) {
                ceil = node.data;
            }
            getCeil(node.left, x);
        }
    }

    class TreeNode<T> {

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
