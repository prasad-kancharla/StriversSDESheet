package com.prasad.companies.google;

// https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/description/
// https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/solutions/1486398/java-two-pointer-approach
class CheckIfWordCanBePlaced {

    public boolean placeWordInCrossword(char[][] board, String word) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    for (int[] direction : directions) {
                        // previouscell cannot be empty space or an alphabet
                        // previous cell depends on direction
                        int row = i;
                        int col = j;

                        if (isValidCell(row - direction[0], col - direction[1], numberOfRows, numberOfColumns) && board[row - direction[0]][col - direction[1]] != '#') {
                            continue;
                        }

                        int index = 0;
                        while (index < word.length() && isValidCell(row, col, numberOfRows, numberOfColumns)) {
                            if (board[row][col] == '#' || (board[row][col] != ' ' && board[row][col] != word.charAt(index))) {
                                break;
                            }
                            row += direction[0];
                            col += direction[1];
                            index++;
                        }
                        // after while loop breaks, check if index is equal to word length - indicates the word can be placed
                        // after this, you need to check if the next cell should not have empty space or alphabet
                        if (index == word.length() && (!isValidCell(row, col, numberOfRows, numberOfColumns) || board[row][col] == '#')) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidCell(int i, int j, int numberOfRows, int numberOfColumns) {
        return i >= 0 && j >= 0 && i < numberOfRows && j < numberOfColumns;
    }

}