package com.prasad.graphs;

class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int n, int m) {
        grid[i][j] = '2';
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];
            boolean isValidCell = newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == '1';
            if (isValidCell) {
                dfs(grid, newI, newJ, n, m);
            }
        }
    }

}