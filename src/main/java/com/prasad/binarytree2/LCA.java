package com.prasad.binarytree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LCA {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(new LCA().lowestCommonAncestor(root, root.left.left, root.left.right).data);
    }

    HashMap<TreeNode, List<TreeNode>> nodePathMap;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        nodePathMap = new HashMap<>();
        List<TreeNode> path = new ArrayList<>();
        getPaths(root, path);
        List<TreeNode> pathOfNode1 = nodePathMap.get(p);
        List<TreeNode> pathOfNode2 = nodePathMap.get(q);

        TreeNode lca = null;

        int i = 0;
        int j = 0;

        int n = pathOfNode1.size();
        int m = pathOfNode2.size();

        while (i < n && j < m && pathOfNode1.get(i) == pathOfNode2.get(j)) {
            lca = pathOfNode1.get(i);
            i++;
            j++;
        }
        return lca;

    }

    private void getPaths(TreeNode root, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        nodePathMap.put(root, new ArrayList<>(path));
        if (root.left != null) {
            getPaths(root.left, path);
        }
        if (root.right != null) {
            getPaths(root.right, path);
        }
        path.remove(path.size() - 1);
    }

}