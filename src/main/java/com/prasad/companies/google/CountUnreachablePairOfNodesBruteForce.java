package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class CountUnreachablePairOfNodesBruteForce {

    int[] visited;

    public long countPairs(int n, int[][] edges) {
        int numberOfEdges = edges.length;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < numberOfEdges; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        visited = new int[n];
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfs(i, adjacencyList);
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0) {
                    String string = i <= j ? i + "-" + j : j + "-" + i;
                    hashSet.add(string);
                }
            }
            visited = new int[n];
        }
        return hashSet.size();
    }

    private void dfs(int node, List<List<Integer>> adjacencyList) {
        if (visited[node] == 1) {
            return;
        }
        visited[node] = 1;
        for (int neighbour : adjacencyList.get(node)) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adjacencyList);
            }
        }
    }

}