package com.prasad.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            int size = adjacencyList.get(i).size();
            for (int j = 0; j < size; j++) {
                inDegree[adjacencyList.get(i).get(j)]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int size = adjacencyList.get(node).size();

            for (int i = 0; i < size; i++) {
                int neighbour = adjacencyList.get(node).get(i);
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }

}