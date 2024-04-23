package com.prasad.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    static List<Integer> list;

    public static List<Integer> getInOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inOrderTraversal(root);
        return list;
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        list.add(root.data);
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

}