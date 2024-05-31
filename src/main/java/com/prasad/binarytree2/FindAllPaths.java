package com.prasad.binarytree2;

import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {

    public static void main(String[] args) {
        TreeNode root = getInput();
        System.out.println(findAllPaths(root, 7));
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

    static List<List<Integer>> paths;

    private static List<List<Integer>> findAllPaths(TreeNode root, int n) {
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPaths(root, path);
        return paths;
    }

    private static void getPaths(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        paths.add(new ArrayList<>(path));

        if (root.left != null) {
            getPaths(root.left, path);
        }
        if (root.right != null) {
            getPaths(root.right, path);
        }

        path.remove(path.size() - 1);
    }

}
