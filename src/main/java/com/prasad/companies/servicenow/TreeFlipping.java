package com.prasad.companies.servicenow;

import java.util.*;

public class TreeFlipping {

    public static int getMinimumOperations(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, List<Integer> initial, List<Integer> expected) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < treeNodes; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < treeFrom.size(); i++) {
            int from = treeFrom.get(i);
            int to = treeTo.get(i);
            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        return dfs(0, -1, 0, 0, tree, initial, expected);
    }

    private static int dfs(int node, int parent, int flipEven, int flipOdd, List<List<Integer>> tree, List<Integer> initial, List<Integer> expected) {
        int currentValue = initial.get(node);
        if ((node % 2 == 0 && flipEven % 2 == 1) || (node % 2 == 1 && flipOdd % 2 == 1)) {
            currentValue = 1 - currentValue;
        }

        int operations = 0;
        if (currentValue != expected.get(node)) {
            operations++;
            if (node % 2 == 0) {
                flipEven++;
            } else {
                flipOdd++;
            }
        }

        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                operations += dfs(neighbor, node, flipEven, flipOdd, tree, initial, expected);
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        // Example usage
        int treeNodes = 4;
        List<Integer> treeFrom = Arrays.asList(0, 0, 1);
        List<Integer> treeTo = Arrays.asList(1, 2, 3);
        List<Integer> initial = Arrays.asList(1, 1, 0, 1);
        List<Integer> expected = Arrays.asList(0, 1, 1, 0);

        int result = getMinimumOperations(treeNodes, treeFrom, treeTo, initial, expected);
        System.out.println("Minimum operations needed: " + result); // Output should be the minimum operations needed
    }
}
