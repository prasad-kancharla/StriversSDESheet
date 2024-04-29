package com.prasad.companies.servicenow;

import java.util.Stack;

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int[] heights = getHeights(matrix, i, m, prev);
            int area = getLargestRectangleArea(heights);
            maxArea = Math.max(area,maxArea);
            prev = heights;
        }
        return maxArea;
    }

    private int[] getHeights(char[][] matrix, int i, int m, int[] prev) {
        int[] heights = new int[m];
        for (int j = 0; j < m; j++) {
            int val = matrix[i][j] == '0' ? 0 : 1;
            heights[j] = val == 0 ? 0 : prev[j] + val;
        }
        return heights;
    }

    public int getLargestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        if (n == 0) {
            return maxArea;
        }

        int[] nsl = getNsl(heights, n);
        int[] nsr = getNsr(heights, n);

        for (int i = 0; i < n; i++) {
            int start = nsl[i] + 1;
            int end = nsr[i] == -1 ? n - 1 : nsr[i] - 1;
            int area = (end - start + 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int[] getNsr(int[] heights, int n) {
        int[] ngr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ngr[i] = -1;
            } else {
                ngr[i] = stack.peek();
            }
            stack.push(i);
        }
        return ngr;
    }

    private int[] getNsl(int[] heights, int n) {
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        return nsl;
    }
}