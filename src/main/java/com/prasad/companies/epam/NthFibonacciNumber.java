package com.prasad.companies.epam;

public class NthFibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fibonacciNumber(95));
    }

    public static int fibonacciNumber(int n) {
        if (n <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int c = 1000000007;
        int i = 2;
        while (i < n) {
            int temp = first;
            first = second;
            second = (second % c + temp % c) % c;
            i++;
        }
        return second;
    }

}