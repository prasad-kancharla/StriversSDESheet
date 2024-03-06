package com.prasad.arraysii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {3, 5}, {2, 4}, {6, 7}};
        System.out.println(new MergeOverlappingSubIntervals().mergeOverlappingIntervals(input));
    }

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        Arrays.sort(arr, (a1, a2) -> a1[0] > a2[0] ? 1 : a1[0] < a2[0] ? -1 : 0);

        int n = arr.length;
        List<Integer> interval = new ArrayList<>();
        interval.add(arr[0][0]);
        interval.add(arr[0][1]);

        for (int i = 1; i < n; i++) {
            if (arr[i][0] > interval.get(1)) {
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(interval.get(0));
                newInterval.add(interval.get(1));
                mergedIntervals.add(newInterval);

                interval.set(0, arr[i][0]);
                interval.set(1, arr[i][1]);
            } else {
                interval.set(0, Math.min(interval.get(0), arr[i][0]));
                interval.set(1, Math.max(interval.get(1), arr[i][1]));
            }
        }
        mergedIntervals.add(interval);
        return mergedIntervals;

    }

}