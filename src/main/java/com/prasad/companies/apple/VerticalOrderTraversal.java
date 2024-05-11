package com.prasad.companies.apple;

import java.util.*;
/************************************************************

 Following is the TreeNode class structure

 class TreeNode<T>
 {
 public:
 T data;
 TreeNode<T> left;
 TreeNode<T> right;

 TreeNode(T data)
 {
 this.data = data;
 left = null;
 right = null;
 }
 };
 ************************************************************/

import java.util.ArrayList;

public class VerticalOrderTraversal {

    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        ArrayList<Integer> verticalOrder = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair currentPair = queue.poll();
                TreeNode<Integer> treeNode = currentPair.treeNode;
                int level = currentPair.level;
                if (treeMap.containsKey(level)) {
                    treeMap.get(level).add(treeNode.data);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(treeNode.data);
                    treeMap.put(level, list);
                }
                if (treeNode.left != null) {
                    queue.offer(new Pair(treeNode.left, level - 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new Pair(treeNode.right, level + 1));
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            int size = entry.getValue().size();
            for (int i = 0; i < size; i++) {
                verticalOrder.add(entry.getValue().get(i));
            }
        }
        return verticalOrder;
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

    static class Pair {

        TreeNode<Integer> treeNode;
        int level;

        Pair(TreeNode<Integer> treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

    }

}
