package com.prasad.recursionandbacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class NQueensLC {
    List<List<String>> solutions;
    HashSet<Integer> hsr;
    HashSet<Integer> hsul;
    HashSet<Integer> hsll;
    public List<List<String>> solveNQueens(int n) {
        hsul = new HashSet<>();
        hsr = new HashSet<>();
        hsll = new HashSet<>();
        solutions = new ArrayList<>();

        StringBuilder emptyRow = new StringBuilder();
        for (int i = 0; i < n; i++) {
            emptyRow.append(".");
        }
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(emptyRow.toString());
        }
        getSolutions(0, solution);
        return solutions;
    }

    private void getSolutions(int column, List<String> way) {
        int n = way.size();
        if (column == n) {
            solutions.add(new ArrayList<>(way));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!hsr.contains(i) && !hsul.contains(i - column) && !hsll.contains(i + column)) {
                StringBuilder sb = new StringBuilder(way.get(i));
                sb.replace(column, column + 1, "Q");
                way.set(i, sb.toString());
                hsr.add(i);
                hsul.add(i - column);
                hsll.add(i + column);
                getSolutions(column + 1, way);
                sb.replace(column, column + 1, ".");
                way.set(i, sb.toString());
                hsr.remove(i);
                hsul.remove(i - column);
                hsll.remove(i + column);
            }
        }
    }

}