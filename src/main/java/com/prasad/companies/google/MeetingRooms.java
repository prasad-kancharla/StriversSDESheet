package com.prasad.companies.google;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
class MeetingRooms {

    public static void main(String[] args) {
        int[][] input = {{0, 30}, {15, 20}, {5, 10}};
        System.out.println(new MeetingRooms().canAttendMeetings(input));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int numberOfIntervals = intervals.length;
        if (numberOfIntervals < 2) {
            return true;
        }
        for (int i = 1; i < numberOfIntervals; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

}