package com.prasad.companies.salesforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MinTapsOptimal {

    HashMap<Pair, Integer> map;

    public int minTaps(int n, int[] ranges) {
        map = new HashMap<>();

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
        Pair key = new Pair(i, maxEnd);
        if (map.containsKey(key)) {
            return map.get(key);
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

        map.put(key, Math.min(count1, count2));
        return map.get(key);
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

    class Pair {

        int i;
        int maxEnd;

        Pair(int i, int maxEnd) {
            this.i = i;
            this.maxEnd = maxEnd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return i == pair.i && maxEnd == pair.maxEnd;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, maxEnd);
        }

    }

}
