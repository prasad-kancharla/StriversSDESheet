package com.prasad.companies.google;

public class UnionSetQuickFind {

    public static void main(String[] args) {
        UnionSetQuickFind unionSet = new UnionSetQuickFind(10);
        unionSet.union(0, 1);
        unionSet.union(0, 2);
        unionSet.union(1, 3);
        unionSet.union(4, 8);
        unionSet.union(5, 6);
        unionSet.union(5, 7);
        System.out.println(unionSet.isConnected(0, 3));
        System.out.println(unionSet.isConnected(1, 5));
        System.out.println(unionSet.isConnected(7, 8));
        unionSet.union(2, 6);
        System.out.println(unionSet.isConnected(1, 5));
    }

    private int[] root;

    public UnionSetQuickFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    public void union(int node1, int node2) {
        int rootOfNode1 = findRoot(node1);
        int rootOfNode2 = findRoot(node2);
        if (rootOfNode1 != rootOfNode2) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootOfNode2) {
                    root[i] = rootOfNode1;
                }
            }
        }
    }

    public boolean isConnected(int node1, int node2) {
        return findRoot(node1) == findRoot(node2);
    }

    private int findRoot(int node) {
        return root[node];
    }

}
