package com.prasad.recursionandbacktracking;

public class SudokuSolverCN {

    public static boolean sudokuSolver(int board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    int temp = board[i][j];
                    board[i][j] = 0;
                    if (!isValid(temp, i, j, board)) {
                        return false;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return solve(board);
    }

    public static boolean solve(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        if (isValid(k, i, j, board)) {
                            board[i][j] = k;
                            if (sudokuSolver(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int c, int row, int col, int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }

            if (board[row][i] == c) {
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

}
