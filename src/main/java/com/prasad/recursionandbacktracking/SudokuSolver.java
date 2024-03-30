package com.prasad.recursionandbacktracking;

class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    }

    public void solveSudoku(char[][] board) {
        fillBoard(0, 0, board);
    }

    private boolean fillBoard(int i, int j, char[][] board) {
        if (i == 9) {
            return true;
        }

        if (j == 9) {
            return fillBoard(i + 1, 0, board);
        }

        if (i < 9 && j < 9 && board[i][j] != '.') {
            return fillBoard(i, j + 1, board);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(c, i, j, board)) {
                board[i][j] = c;
                if (fillBoard(i, j + 1, board)) {
                    return true;
                } else {
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private boolean isValid(char c, int row, int column, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][column] == c) {
                return false;
            }
        }

        int blockRow = (row / 3) * 3;
        int blockColumn = (column / 3) * 3;
        for (int i = blockRow; i < blockRow + 3; i++) {
            for (int j = blockColumn; j < blockColumn + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

}