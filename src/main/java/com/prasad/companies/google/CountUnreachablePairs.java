package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
class CountUnreachablePairs {

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int sizeOfComponent = dfs(i, adjacencyList, visited);
                componentSizes.add(sizeOfComponent);
            }
        }
        long unreachablePairsCount = 0;
        for (int size : componentSizes) {
            unreachablePairsCount += (long) size * (long) (n - size);
        }
        return unreachablePairsCount / 2; // very important since it is undirected graph, pairs (0,1) and (1,0) will be there which are duplicates
    }

    private int dfs(int node, List<List<Integer>> adjacencyList, boolean[] visited) {
        visited[node] = true;
        int size = 1;
        List<Integer> neighbours = adjacencyList.get(node);
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                size += dfs(neighbour, adjacencyList, visited);
            }
        }
        return size;
    }

}