package com.prasad.companies.servicenow;

import java.util.LinkedList;
import java.util.Queue;

class CheckCompleteBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean reachedLastNode = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp == null) {
					reachedLastNode = true;
				} else {
					if (reachedLastNode) return false;
					queue.offer(temp.left);
					queue.offer(temp.right);
				}
			}
		}
		return true;
    }




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

}