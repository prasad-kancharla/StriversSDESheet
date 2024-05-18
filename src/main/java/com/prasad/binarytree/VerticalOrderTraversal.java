package com.prasad.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Pair>> columnMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int col = pair.col;
                int row = pair.row;
                TreeNode treeNode = pair.treeNode;
                if (!columnMap.containsKey(col)) {
                    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1, p2) -> {
                        if (p1.row == p2.row) {
                            return p1.treeNode.val - p2.treeNode.val;
                        }
                        return p1.row - p2.row;
                    });
                    columnMap.put(col, priorityQueue);
                }
                columnMap.get(col).offer(pair);

                if (treeNode.left != null) {
                    queue.offer(new Pair(treeNode.left, row + 1, col - 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new Pair(treeNode.right, row + 1, col + 1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Pair>> entry : columnMap.entrySet()) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Pair> priorityQueue = entry.getValue();
            while (!priorityQueue.isEmpty()) {
                list.add(priorityQueue.poll().treeNode.val);
            }
            ans.add(list);
        }
        return ans;
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

    public class Pair {

        TreeNode treeNode;
        int row;
        int col;

        public Pair(TreeNode treeNode, int row, int col) {
            this.col = col;
            this.row = row;
            this.treeNode = treeNode;
        }

    }

}