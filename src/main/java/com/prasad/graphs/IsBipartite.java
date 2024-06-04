package com.prasad.graphs;

class IsBipartite {

    int[] colorOfNode;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colorOfNode = new int[n];
        for (int i = 0; i < n; i++) {
            colorOfNode[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (colorOfNode[i] == -1) {
                if (!dfs(graph, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int color) {
        colorOfNode[node] = color;
        int size = graph[node].length;
        for (int i = 0; i < size; i++) {
            int neighbour = graph[node][i];
            if (colorOfNode[neighbour] != -1) {
                if (colorOfNode[neighbour] == colorOfNode[node]) {
                    return false;
                }
            } else {
                if (!dfs(graph, neighbour, 1 - color)) {
                    return false;
                }
            }
        }
        return true;
    }

}