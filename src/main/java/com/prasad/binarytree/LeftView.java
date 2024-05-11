package com.prasad.binarytree;

import java.util.*;

import java.util.ArrayList;

public class LeftView {

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        if (root == null) {
            return leftView;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (i == 0) {
                    leftView.add(temp.data);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }

        return leftView;
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

    ;
}
