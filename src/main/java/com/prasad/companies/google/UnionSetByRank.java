package com.prasad.companies.google;

public class UnionSetByRank {
    int[] parent;
    int[] rank;

    public UnionSetByRank(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    public void union (int node1, int node2) {
        int rootOfNode1 = findRoot(node1);
        int rootOfNode2 = findRoot(node2);
        if (rootOfNode1 != rootOfNode2) {
            if (rank[rootOfNode1] > rank[rootOfNode2]) {
                parent[rootOfNode2] = rootOfNode1;
            } else if (rank[rootOfNode2] > rank[rootOfNode1]) {
                parent[rootOfNode1] = rootOfNode2;
            } else {
                parent[rootOfNode2] = rootOfNode1;
                rank[rootOfNode1]++;
            }
        }
    }

    public boolean isConnected(int node1, int node2) {
        return findRoot(node1) == findRoot(node2);
    }

}
