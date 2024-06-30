package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> binaryTree = new ArrayList<>();
        int heightOfBinaryTree = getHeight(root);
        int numberOfStringsInLevel = (int) Math.pow(2, (heightOfBinaryTree + 1)) - 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, (numberOfStringsInLevel - 1) / 2));

        while (!queue.isEmpty()) {
            int treeNodesSize = queue.size();
            List<String> currentLevel = getLevel(numberOfStringsInLevel);
            for (int i = 0; i < treeNodesSize; i++) {
                Pair currentPair = queue.poll();
                TreeNode currentNode = currentPair.treeNode;
                int col = currentPair.col;
                int row = currentPair.row;
                currentLevel.set(col, String.valueOf(currentNode.val));

                if (currentNode.left != null) {
                    queue.offer(new Pair(currentNode.left, row + 1, col - (int) Math.pow(2, heightOfBinaryTree - row - 1)));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair(currentNode.right, row + 1, col + (int) Math.pow(2, heightOfBinaryTree - row - 1)));
                }
            }
            binaryTree.add(currentLevel);
        }
        return binaryTree;
    }

    private List<String> getLevel(int n) {
        List<String> level = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            level.add("");
        }
        return level;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    class Pair {

        TreeNode treeNode;
        int row;
        int col;

        public Pair(TreeNode treeNode, int row, int col) {
            this.treeNode = treeNode;
            this.row = row;
            this.col = col;
        }

    }

}