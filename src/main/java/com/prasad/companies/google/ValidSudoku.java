package com.prasad.companies.google;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> used = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!used.add(c + "present in row " + i) ||
                            !used.add(c + "present in col " + j) ||
                            !used.add(c + "present in block " + i / 3 + " " + j / 3)
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}