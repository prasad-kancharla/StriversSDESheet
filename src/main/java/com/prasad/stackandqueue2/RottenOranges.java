package com.prasad.stackandqueue2;

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int time = -1;
        int[] X = {0, 0, 1, -1};
        int[] Y = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = pair.x + X[k];
                    int newY = pair.y + Y[k];
                    boolean isValidCell = newX >= 0 && newX < n && newY >= 0 && newY < m;
                    if (isValidCell && grid[newX][newY] == 1) {
                        queue.offer(new Pair(newX, newY));
                        grid[newX][newY] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        if (time == -1) {
            time++;
        }
        return time;
    }

    class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}