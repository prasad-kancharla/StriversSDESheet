package com.prasad.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetsSumToKCN {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(-2);
        input.add(0);
        input.add(-5);
        input.add(2);
        System.out.println(findSubsetsThatSumToK(input, 5, 0));
    }

    static Set<ArrayList<Integer>> subsets;

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        subsets = new HashSet<>();
        ArrayList<Integer> subset = new ArrayList<>();
        getSubsets(arr, n, k, 0, subset);
        return (ArrayList<ArrayList<Integer>>) subsets.stream().collect(Collectors.toList());
    }

    private static void getSubsets(ArrayList<Integer> arr, int n, int k, int i, ArrayList<Integer> subset) {
        if (k == 0) {
            subsets.add(new ArrayList<>(subset));
        }

        if (i == n) {
            return;
        }

        subset.add(arr.get(i));
        getSubsets(arr, n, k - arr.get(i), i + 1, subset);
        subset.remove(subset.size() - 1);

        while (i + 1 < n && arr.get(i + 1) == arr.get(i)) {
            i++;
        }
        getSubsets(arr, n, k, i + 1, subset);
    }

}