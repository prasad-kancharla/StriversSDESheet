package com.prasad.graphs;

import java.util.ArrayList;

class DFS {

    ArrayList<Integer> dfsList;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        dfsList = new ArrayList<>();
        int[] visited = new int[V];
        dfs(0, adj, visited);
        return dfsList;
    }

    private void dfs (int i, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        if (i == visited.length) {
            return;
        }

        visited[i] = 1;
        dfsList.add(i);
        int size = adj.get(i).size();
        for (int j = 0; j < size; j++) {
            int neighbour = adj.get(i).get(j);
            if (visited[neighbour] == 0) {
                dfs(neighbour, adj, visited);
            }
        }
    }
}