package com.prasad.binarytree;

import java.util.ArrayList;
import java.util.List;

class RootToLeafNodePaths {

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    static ArrayList<ArrayList<Integer>> paths;

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPaths(root, path);
        return paths;
    }

    private static void getPaths(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }
        if (root.left != null) getPaths(root.left, path);
        if (root.right != null) getPaths(root.right, path);
        path.remove(path.size() - 1);
    }

}
  