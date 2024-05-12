package com.prasad.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopViewOfBinaryTree {

    public static List<Integer> getTopView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode treeNode = pair.treeNode;
                int level = pair.level;
                if (!treeMap.containsKey(level)) {
                    treeMap.put(level, treeNode.data);
                }
                if (treeNode.left != null) {
                    queue.offer(new Pair(treeNode.left, level - 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new Pair(treeNode.right, level + 1));
                }
            }
        }

        return treeMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
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

    static class Pair {

        TreeNode treeNode;
        int level;

        public Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

    }

}
