package com.prasad.recursion;

import java.util.ArrayList;
import java.util.List;

class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(new PermutationSequenceBruteForce().getPermutation(3, 3));
    }

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

}