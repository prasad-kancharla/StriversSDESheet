package com.prasad.arraysiv;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumBruteForce {

    public static void main(String[] args) {
        int[] input = {-1, -1, 2, 0, 1};
        System.out.println(triplet(5, input));
    }

    public static List<List<Integer>> triplet(int n, int[] arr) {
        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets.stream().collect(Collectors.toList());

    }

}