package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/delete-nodes-and-return-forest/description/
class DeleteNodes {
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        int length = to_delete.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            hashSet.add(to_delete[i]);
        }
        dfs(root, hashSet, true);
        return ans;
    }

    private TreeNode dfs(TreeNode treeNode, HashSet<Integer> hashSet, boolean isRoot) {
        if (treeNode == null) {
            return null;
        }

        boolean canBeDeleted = hashSet.contains(treeNode.val);
        if (isRoot && !canBeDeleted) {
            ans.add(treeNode);
        }

        treeNode.left = dfs(treeNode.left, hashSet, canBeDeleted);
        treeNode.right = dfs(treeNode.right, hashSet, canBeDeleted);

        return canBeDeleted ? null : treeNode;
    }

}