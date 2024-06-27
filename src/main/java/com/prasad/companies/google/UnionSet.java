package com.prasad.companies.google;

public class UnionSet {

    int[] parent;
    int[] rank;

    public UnionSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findRoot(parent[node]); // path compression
        return parent[node];
    }

    public void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if (rootX != rootY) { // union by rank 
            if (rank[rootX] > rank[rootY]) {
                rank[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                rank[rootX] = rootY;
            } else {
                rank[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

}
