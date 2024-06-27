package com.prasad.companies.google;

public class UnionSetQuickUnion {

    int[] parent;

    public UnionSetQuickUnion(int size) {
        parent = new int[size];
    }

    public int findRoot(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    public void union(int node1, int node2) {
        int rootOfNode1 = findRoot(node1);
        int rootOfNode2 = findRoot(node2);
        if (rootOfNode1 != rootOfNode2) {
            parent[node2] = rootOfNode1;
        }
    }

    public boolean isConnected(int node1, int node2) {
        return findRoot(node1) == findRoot(node2);
    }

}
