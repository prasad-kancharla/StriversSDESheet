package com.prasad.recursion;

import java.util.* ;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        System.out.println(subsetSum(arr));
    }

    static ArrayList<Integer> subsetSums;
    public static ArrayList<Integer> subsetSum(int num[]) {
        subsetSums = new ArrayList<>();
        int sum = 0;
        getSubsetSums(num, 0, sum);
        Collections.sort(subsetSums);
        return subsetSums;

    }

    private static void getSubsetSums(int[] num, int i, int sum) {
        if (i == num.length) {
            subsetSums.add(sum);
            return;
        }
        getSubsetSums(num, i + 1, sum);
        getSubsetSums(num, i + 1, sum + num[i]);
    }

}