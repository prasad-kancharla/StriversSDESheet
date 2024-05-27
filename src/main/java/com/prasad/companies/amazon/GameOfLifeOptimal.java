package com.prasad.companies.amazon;

import java.util.Arrays;

class GameOfLifeOptimal {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLifeOptimal().gameOfLife(board);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    // we can give any mapping number to any pair of values but mapping can be done in such a way that we can use mapping % 2 to get original value
    // Original Updated Mapping
    //     0      0       0
    //     1      0       1
    //     0      1       2
    //     1      1       3

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] y = {1, -1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = board[i][j];
                int liveNeighboursCount = getLiveNeighboursCount(board, i, j, x, y);
                if (board[i][j] == 1) {
                    if (liveNeighboursCount < 2 || liveNeighboursCount > 3) {
                        value = 0;
                    }
                } else if (board[i][j] == 0 && liveNeighboursCount == 3) {
                    value = 1;
                }

                if (board[i][j] == 0 && value == 0) {
                    board[i][j] = 0;
                } else if (board[i][j] == 1 && value == 0) {
                    board[i][j] = 1;
                } else if (board[i][j] == 0 && value == 1) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && value == 1) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || board[i][j] == 1) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveNeighboursCount(int[][] board, int i, int j, int[] x, int[] y) {
        int n = board.length;
        int m = board[0].length;
        int liveNeighboursCount = 0;
        for (int k = 0; k < 8; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];
            boolean isValidCell = newI >= 0 && newI < n && newJ >= 0 && newJ < m;
            if (isValidCell && board[newI][newJ] % 2 == 1) {
                liveNeighboursCount++;
            }
        }
        return liveNeighboursCount;
    }

}