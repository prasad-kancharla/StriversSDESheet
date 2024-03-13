package com.prasad.arraysiv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumOptimal {

    public static void main(String[] args) {
        int[] input = {-1, -1, 2, 0, 1};
        System.out.println(triplet(5, input));
    }
    public static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    triplets.add(list);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return triplets;
    }

}