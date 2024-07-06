package com.prasad.companies.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/single-threaded-cpu/description/
class SingleThreadedCpu {

    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.toString(new SingleThreadedCpu().getOrder(tasks)));
    }

    public int[] getOrder(int[][] tasks) {
        int numberOfTasks = tasks.length;
        int[] order = new int[numberOfTasks];
        int[][] indexedTasks = new int[numberOfTasks][3];
        for (int i = 0; i < numberOfTasks; i++) {
            indexedTasks[i][0] = tasks[i][0];
            indexedTasks[i][1] = tasks[i][1];
            indexedTasks[i][2] = i;
        }

        Arrays.sort(indexedTasks, Comparator.comparingInt(task -> task[0]));

        Comparator<int[]> taskComparator = (t1, t2) -> {
            if (t1[1] != t2[1]) {
                return t1[1] - t2[1];
            }
            return t1[2] - t2[2];
        };
        PriorityQueue<int[]> availableTasks = new PriorityQueue<>(taskComparator);
        int i = 0;
        int time = 0;
        int k = 0;
        while (i < numberOfTasks || !availableTasks.isEmpty()) {

            while (i < numberOfTasks && time >= indexedTasks[i][0]) {
                availableTasks.offer(indexedTasks[i]);
                i++;
            }
            if (!availableTasks.isEmpty()) {
                int[] pickedTask = availableTasks.poll();
                order[k++] = pickedTask[2];
                time += pickedTask[1];
            } else {
                if (i < numberOfTasks) {
                    time = indexedTasks[i][0];
                }
            }

        }
        return order;
    }

}