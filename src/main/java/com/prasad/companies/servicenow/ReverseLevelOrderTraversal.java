package com.prasad.companies.servicenow;

import java.util.Collections;
import java.util.*;

public class ReverseLevelOrderTraversal {

    public static ArrayList<Integer> reverseLevelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.data);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        Collections.reverse(list);
        return list;
    }

    class TreeNode {

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