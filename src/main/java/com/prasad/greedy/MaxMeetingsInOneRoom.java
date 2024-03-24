package com.prasad.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMeetingsInOneRoom {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maximumMeetings(start,end));
    }

    public static int maximumMeetings(int[] start, int[] end) {
        int n = start.length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(start[i], end[i]));
        }
        Comparator<Pair> pairComparator = (p1, p2) -> p1.end < p2.end ? -1 : p1.end > p2.end ? 1 : 0;
        Collections.sort(pairs, pairComparator);

        int count = 0;
        int meetingEnd = pairs.get(0).end;
        for (int i = 1; i < n; i++) {
           if (pairs.get(i).start > meetingEnd) {
               count++;
               meetingEnd = pairs.get(i).end;
           }
        }
        return count;
    }

    static class Pair {

        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

}
