package com.prasad.companies.apple;

import java.util.TreeSet;

class MinimizeDeviationInArrayUsingTreeSet {

    public static void main(String[] args) {
        int[] input = {2, 10, 8};
        System.out.println(new MinimizeDeviationInArrayUsingTreeSet().minimumDeviation(input));
    }

    public int minimumDeviation(int[] nums) {
        int minDeviation = Integer.MAX_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums) {
            if (i % 2 == 1) {
                i = i * 2;
            }
            treeSet.add(i);
        }

        while (treeSet.last() % 2 == 0) {
            minDeviation = Math.min(treeSet.last() - treeSet.first(), minDeviation);
            int max = treeSet.last();
            treeSet.add(max / 2);
            treeSet.remove(max);
        }

        return Math.min(treeSet.last() - treeSet.first(), minDeviation);
    }

}