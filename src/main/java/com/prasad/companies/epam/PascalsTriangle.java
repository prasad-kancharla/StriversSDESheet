package com.prasad.companies.epam;

import java.util.ArrayList;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(printPascal(3));
    }

    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> pascal = new ArrayList<>();
        ArrayList<Long> first = new ArrayList<>();
        first.add(1L);
        pascal.add(first);
        if (n == 1) {
            return pascal;
        }
        ArrayList<Long> prev = new ArrayList<>();
        prev.add(1L);
        prev.add(1L);
        pascal.add(prev);
        if (n == 2) {
            return pascal;
        }

        for (int i = 2; i < n; i++) {
            ArrayList<Long> row = new ArrayList<>();
            row.add(1L);
            int m = prev.size();
            for (int j = 0; j < m - 1; j++) {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            row.add(1L);
            pascal.add(row);
            prev = row;
        }

        return pascal;
    }

}
