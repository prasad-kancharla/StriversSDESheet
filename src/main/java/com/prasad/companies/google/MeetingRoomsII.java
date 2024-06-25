package com.prasad.companies.google;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/description/
class MeetingRoomsII {

    public static void main(String[] args) {
        int[][] input = {{0, 30}, {15, 20}, {5, 10}};
        System.out.println(new MeetingRoomsII().minMeetingRooms(input));
    }

    public int minMeetingRooms(int[][] intervals) {
        int numberOfIntervals = intervals.length;
        if (numberOfIntervals < 2) {
            return numberOfIntervals;
        }
        int numberOfMeetingRooms = 0;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> endTimes = new PriorityQueue();
        for (int i = 0; i < numberOfIntervals; i++) {
            if (endTimes.isEmpty()) {
                numberOfMeetingRooms++;
            } else {
                if (endTimes.peek() <= intervals[i][0]) {
                    endTimes.poll();
                } else {
                    numberOfMeetingRooms++;
                }
            }
            endTimes.offer(intervals[i][1]);
        }
        return numberOfMeetingRooms;
    }

}