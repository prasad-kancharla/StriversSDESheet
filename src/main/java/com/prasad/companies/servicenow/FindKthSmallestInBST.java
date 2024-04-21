package com.prasad.companies.servicenow;

import java.util.ArrayList;
import java.util.List;

public class FindKthSmallestInBST {

    static List<Integer> sortedList;

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        if (root == null) {
            return -1;
        }
        sortedList = new ArrayList<>();
        findKthSmallest(root);
        if (k > sortedList.size()) {
            return -1;
        }
        return sortedList.get(k - 1);
    }

    private static void findKthSmallest(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        findKthSmallest(root.left);
        sortedList.add(root.data);
        findKthSmallest(root.right);
    }

}