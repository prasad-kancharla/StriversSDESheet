package com.prasad.companies.epam;

import java.util.*;

public class NextSmallestElementOptimal {

    public static void main(String[] args) {
        List<Integer> arr = List.of(2,3,1);
        System.out.println(nextSmallerElement(arr,3));
    }

    static ArrayList<Integer> nextSmallerElement(List<Integer> arr, int n) {
        ArrayList<Integer> smallerElements = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                smallerElements.add(0, -1);
            } else {
                smallerElements.add(0, stack.peek());
            }
            stack.push(arr.get(i));
        }
        return smallerElements;
    }

}