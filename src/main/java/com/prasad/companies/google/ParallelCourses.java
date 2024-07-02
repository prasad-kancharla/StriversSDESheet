package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/parallel-courses/description/
class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList());
        }
        int numberOfRelations = relations.length;
        int[] inDegree = new int[n];

        for (int i = 0; i < numberOfRelations; i++) {
            int[] relation = relations[i];
            adjacencyList.get(relation[0] - 1).add(relation[1] - 1);
            inDegree[relation[1] - 1]++;
        }

        Queue<Integer> queue = new LinkedList();
        int[] completed = new int[n];
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int numberOfSemesters = 0;

        while (!queue.isEmpty()) {
            numberOfSemesters++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int currentCourse = queue.poll();
                completed[currentCourse] = 1;
                List<Integer> nextCourses = adjacencyList.get(currentCourse);
                for (int nextCourse : nextCourses) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (completed[i] == 0) {
                return -1;
            }
        }
        return numberOfSemesters;
    }

}