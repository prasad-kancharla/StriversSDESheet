package com.prasad.companies.jpmorgan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GetMinMeetingRooms {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> m1 = new ArrayList<>();
        m1.add(3);
        m1.add(4);
        List<Integer> m2 = new ArrayList<>();
        m2.add(1);
        m2.add(2);
        list.add(m1);
        list.add(m2);

        System.out.println("a".compareTo("c"));

    }

    public static int getMinRooms(List<List<Integer>> meetingTimings) {
        Comparator<List<Integer>> meetingComparator = Comparator.comparingInt(l -> l.get(0));
        Collections.sort(meetingTimings, meetingComparator);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        int n = meetingTimings.size();
        for (int i = 0; i < n; i++) {
            List<Integer> currentMeeting = meetingTimings.get(i);
            if (!rooms.isEmpty() && currentMeeting.get(0) <= rooms.peek()) {
                rooms.poll();
            }
            rooms.offer(currentMeeting.get(1));
        }
        return rooms.size();
    }

}
