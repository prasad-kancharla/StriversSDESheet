package com.prasad.stackandqueue;

import java.util.Stack;

class ValidParentheses {

    public static void main(String[] args) {
        String s = "(])";
        System.out.println(new ValidParentheses().isValid(s));
    }

    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatching(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }

}