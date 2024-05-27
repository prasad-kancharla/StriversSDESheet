package com.prasad.companies.amazon;

import java.util.Arrays;

class GameOfLifeWithExtraSpace {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLifeWithExtraSpace().gameOfLife(board);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] finalBoard = new int[n][m];

        int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] y = {1, -1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = board[i][j];
                int liveNeighboursCount = 0;
                for (int k = 0; k < 8; k++) {
                    int newI = i + x[k];
                    int newJ = j + y[k];
                    boolean isValidCell = newI >= 0 && newI < n && newJ >= 0 && newJ < m;
                    if (isValidCell && board[newI][newJ] == 1) {
                        liveNeighboursCount++;
                    }
                }
                if (board[i][j] == 1) {
                    if (liveNeighboursCount < 2 || liveNeighboursCount > 3) {
                        value = 0;
                    }
                } else if (board[i][j] == 0 && liveNeighboursCount == 3) {
                   value = 1;
                }
                finalBoard[i][j] = value;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = finalBoard[i][j];
            }
        }
    }

}