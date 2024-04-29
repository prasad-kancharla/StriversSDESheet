package com.prasad.stackandqueue2;

import java.util.Stack;

class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(arr));
    }

    public int largestRectangleArea(int[] heights) {
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