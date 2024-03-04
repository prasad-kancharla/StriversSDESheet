package com.prasad.arrays;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> first = List.of(1);
        List<Integer> second = List.of(1,1);

        pascalTriangle.add(first);
        if (numRows == 1) {
            return pascalTriangle;
        }
        pascalTriangle.add(second);
        if (numRows == 2) {
            return pascalTriangle;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> previousRow = pascalTriangle.get(i - 1);
            int size = previousRow.size();
            for (int j = 0; j < size - 1; j++) {
                row.add(previousRow.get(j) + previousRow.get(j + 1));
            }
            row.add(1);
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}