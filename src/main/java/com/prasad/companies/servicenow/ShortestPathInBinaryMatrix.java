package com.prasad.companies.servicenow;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        grid[0][0] = 1;
        int[] x = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] y = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (temp[0] == n - 1 && temp[1] == n - 1) {
                return temp[2];
            }

            for (int i = 0; i < 8; i++) {
                int newX = temp[0] + x[i];
                int newY = temp[1] + y[i];
                if (newX >= 0 && newY >= 0 && newX < n && newY < n && grid[newX][newY] == 0) {
                    queue.offer(new int[] {newX, newY, temp[2] + 1});
                    grid[newX][newY] = 1;
                }
            }
        }
        return -1;
    }

}