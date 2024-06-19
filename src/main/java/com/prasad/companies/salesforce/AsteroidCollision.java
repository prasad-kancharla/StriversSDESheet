package com.prasad.companies.salesforce;

import java.util.Arrays;
import java.util.Stack;

class AsteroidCollision {

    public static void main(String[] args) {
        int[] input = {-2, -2, 1, -2};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(input)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        stack.push(asteroids[0]);
        int i = 1;
        while (i < n) {
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && i < n && asteroids[i] < 0) {
                destroyed = true;
                int absCurr = Math.abs(asteroids[i]);
                int absPrev = Math.abs(stack.peek());

                if (absPrev > absCurr) {
                    i++;
                } else if (absCurr > absPrev) {
                    stack.pop();
                } else {
                    stack.pop();
                    i++;
                }
            }

            if (!destroyed) {
                stack.push(asteroids[i]);
                i++;
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int j = size - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }

}