package com.prasad.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Djikstra {
    public int[] solve(int A, int[][] B, int C) {
        int[] shortestDistance = new int[A];
        List<List<Pair>> adjacenyList = new ArrayList<>();
        int n = B.length;
        for (int i = 0; i < A; i++) {
            adjacenyList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adjacenyList.get(B[i][0]).add(new Pair(B[i][1], B[i][2]));
            adjacenyList.get(B[i][1]).add(new Pair(B[i][0], B[i][2]));
        }

        for (int i = 0; i < A; i++) {
            shortestDistance[i] = -1;
        }

        shortestDistance[C] = 0;
        Queue<Pair> queue = new PriorityQueue<>((par1, pair2) -> par1.distance - pair2.distance);
        int size = adjacenyList.get(C).size();
        for (int i = 0; i < size; i++) {
            queue.offer(adjacenyList.get(C).get(i));
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int distance = pair.distance;
            int node = pair.node;

            if (shortestDistance[node] == -1) {
                shortestDistance[node] = distance;
                int m = adjacenyList.get(node).size();
                for (int i = 0; i < m; i++) {
                    Pair neighbour = adjacenyList.get(node).get(i);
                    queue.offer(new Pair(neighbour.node, neighbour.distance + distance));
                }
            }
        }

        return shortestDistance;
    }

    class Pair {
        int node;
        int distance;

        public Pair (int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
