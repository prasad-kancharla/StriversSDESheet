package com.prasad.companies.salesforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinTaps {

    int[][] dp;

    public int minTaps(int n, int[] ranges) {
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }

        }
        List<Range> rangeList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int start = Math.max(i - ranges[i], 0);
            int end = Math.min(i + ranges[i], n);
            rangeList.add(new Range(start, end));
        }
        Comparator<Range> rangeComparator = Comparator.comparingInt(Range::getStart).thenComparingInt(Range::getEnd);
        Collections.sort(rangeList, rangeComparator);
        int minTaps = getTapsCount(0, 0, rangeList);
        if (minTaps == Integer.MAX_VALUE) {
            return -1;
        }
        return minTaps;
    }

    private int getTapsCount(int i, int maxEnd, List<Range> rangeList) {
        if (maxEnd >= rangeList.size() - 1) {
            return 0;
        }
        if (i >= rangeList.size()) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][maxEnd] != -1) {
            return dp[i][maxEnd];
        }
        Range range = rangeList.get(i);
        if (range.start > maxEnd) {
            return Integer.MAX_VALUE;
        }
        int count1 = getTapsCount(i + 1, maxEnd, rangeList);
        int count2 = Integer.MAX_VALUE;
        if (range.end > maxEnd) {
            int nextCount = getTapsCount(i + 1, range.end, rangeList);
            count2 = nextCount != Integer.MAX_VALUE ? 1 + nextCount : Integer.MAX_VALUE;
        }

        dp[i][maxEnd] = Math.min(count1, count2);
        return dp[i][maxEnd];
    }

    class Range {

        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

    }

}
