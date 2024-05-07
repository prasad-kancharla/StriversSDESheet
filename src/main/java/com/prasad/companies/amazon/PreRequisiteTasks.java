package com.prasad.companies.amazon;

import java.util.* ;

public class PreRequisiteTasks {
    public static boolean prerequisiteTask(int[][] dependency, int n, int m) {
       List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjacencyList.get(dependency[i][0] - 1).add(dependency[i][1]);
        }

        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            int size = adjacencyList.get(i).size();
            for (int j = 0; j < size; j++) {
                inDegree[adjacencyList.get(i).get(j) - 1]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) return false;
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int index = queue.poll();
            int size = adjacencyList.get(index).size();
            for (int i = 0; i < size; i++) {
                int neighbour = adjacencyList.get(index).get(i);
                inDegree[neighbour - 1]--;
                if (inDegree[neighbour - 1] == 0) {
                    queue.offer(neighbour - 1);
                }
            }
        }
        return count == n;
    }
}

