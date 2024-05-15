package com.prasad.companies.servicenow;

import java.util.Arrays;
import java.util.Stack;

class AsteroidCollision {

    public static void main(String[] args) {
        int[] input = {10, 2, -5};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(input)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        stack.push(0);
        int i = 1;
        while (i < n) {
            boolean destroyed = false;
            while (!stack.isEmpty() && i < n && asteroids[i] < 0 && asteroids[stack.peek()] > 0) {
                destroyed = true;
                int absPrev = Math.abs(asteroids[stack.peek()]);
                int absCurr = Math.abs(asteroids[i]);
                if (absCurr > absPrev) {
                    stack.pop();
                } else if (absCurr < absPrev) {
                    i++;
                } else {
                    stack.pop();
                    i++;
                }
            }

            if (!destroyed) {
                stack.push(i);
                i++;
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int k = size - 1; k >= 0; k--) {
            ans[k] = asteroids[stack.pop()];
        }
        return ans;
    }

}