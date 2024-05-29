package com.prasad.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsList = new ArrayList<>();
        int[] visited = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsList.add(node);
            int size = adj.get(node).size();

            for (int i = 0; i < size; i++) {
                int neighbour = adj.get(node).get(i);
                if (visited[neighbour] == 0) {
                    queue.offer(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }

        return bfsList;
    }

}