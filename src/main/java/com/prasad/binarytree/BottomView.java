package com.prasad.binarytree;

import java.util.*;

public class BottomView {

    public static void main(String[] args) {
        TreeNode root = getInput();
        System.out.println(bottomView(root));
    }

    private static TreeNode getInput() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static List<Integer> bottomView(TreeNode root) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        List<Integer> bottomView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair currentPair = queue.poll();
                int level = currentPair.level;
                TreeNode treeNode = currentPair.treeNode;
                treeMap.put(level, treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(new Pair(treeNode.left, currentPair.level - 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new Pair(treeNode.right, currentPair.level + 1));
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            bottomView.add(entry.getValue());
        }

        return bottomView;
    }

    static class Pair {

        TreeNode treeNode;
        int level;

        Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

}
