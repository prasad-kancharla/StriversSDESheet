package com.prasad.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TopologicalSort {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topoloicalList = new int[V];
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            int size = adj.get(i).size();
            for (int j = 0; j < size; j++) {
                inDegree[adj.get(i).get(j)]++;
            }
        }
        int k = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoloicalList[k++] = node;

            int neighboursSize = adj.get(node).size();
            for (int i = 0; i < neighboursSize; i++) {
                int neighbour = adj.get(node).get(i);
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return topoloicalList;
    }

}