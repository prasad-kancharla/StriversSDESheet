package com.prasad.recursionandbacktracking;

import java.util.ArrayList;
import java.util.HashSet;

public class NQueens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    static ArrayList<ArrayList<Integer>> configurations;
    static HashSet<Integer> hsr;
    static HashSet<Integer> hsul;
    static HashSet<Integer> hsll;

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        configurations = new ArrayList<>();
        hsr = new HashSet<>();
        hsll = new HashSet<>();
        hsul = new HashSet<>();
        int[][] board = new int[n][n];
        getConfigurations(board, 0);
        return configurations;
    }

    private static void getConfigurations(int[][] board, int column) {
        int n = board.length;
        if (column > n) {
            return;
        }

        if (column== n) {
            ArrayList<Integer> configuration = new ArrayList<>();
            for (int l = 0; l < n; l++) {
                for (int m = 0; m < n; m++) {
                    configuration.add(board[l][m]);
                }
            }
            configurations.add(configuration);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!hsr.contains(i) && !hsul.contains(i - column) && !hsll.contains(i + column)) {
                hsr.add(i);
                hsul.add(i - column);
                hsll.add(i + column);
                board[i][column] = 1;
                getConfigurations(board, column + 1);
                board[i][column] = 0;
                hsr.remove(i);
                hsul.remove(i - column);
                hsll.remove(i + column);
            }
        }

    }

}