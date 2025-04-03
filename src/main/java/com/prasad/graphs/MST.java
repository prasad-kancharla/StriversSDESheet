package com.prasad.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST {
    public int getMST(int n, int[][] edges) {
        int minWeight = 0;

        List<List<Pair>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(new Pair(edge[2], edge[1]));
            adjacencyList.get(edge[1]).add(new Pair(edge[2], edge[0]));
        }

        Queue<Pair> queue = new PriorityQueue<>((pair1, pair2) -> pair1.weight - pair2.weight);
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int weight = pair.weight;
            int node = pair.node;

            if (visited[node]) {
                continue;
            }

            minWeight += weight; // avoiding cycles
            visited[node] = true;

            for (Pair neighbourPair : adjacencyList.get(node)) {
                queue.offer(neighbourPair);
            }
        }

        return minWeight;
    }

    class Pair {
        int weight;
        int node;

        Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }
}
