package com.prasad.companies.servicenow;

class ShortestPathBinaryMatrixBF {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1, 0}};
        int[][] input = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};

        System.out.println(new ShortestPathBinaryMatrixBF().shortestPathBinaryMatrix(grid));
    }

    static int minPath;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        minPath = Integer.MAX_VALUE;
        getShortestPath(grid, 0, 0, n, 1);
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }

    private void getShortestPath(int[][] grid, int i, int j, int n, int count) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 1) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            minPath = Math.min(minPath, count);
            return;
        }

        int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] y = {1, -1, 0, 0, 1, -1, 1, -1};
        grid[i][j] = 1;
        for (int k = 0; k < 8; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];
            getShortestPath(grid, newI, newJ, n, count + 1);

        }
        grid[i][j] = 0;
    }

}