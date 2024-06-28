package com.prasad.companies.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        int[] bookingsInRoom = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));

        PriorityQueue<MeetingRoom> availableRooms = new PriorityQueue<>(Comparator.comparingInt(MeetingRoom::getRoom));
        for (int i = 0; i < n; i++) {
            availableRooms.offer(new MeetingRoom(i, 0));
        }
        PriorityQueue<MeetingRoom> usedRooms = new PriorityQueue<>(Comparator.comparing(MeetingRoom::getMeetingEndTime)
                .thenComparingInt(MeetingRoom::getRoom));
        int numberOfMeetings = meetings.length;
        for (int i = 0; i < numberOfMeetings; i++) {
            int currentStartTime = meetings[i][0];
            int currentEndTime = meetings[i][1];

            while (!usedRooms.isEmpty() && usedRooms.peek().getMeetingEndTime() <= currentStartTime) {
                MeetingRoom meetingRoom = usedRooms.poll();
                availableRooms.offer(meetingRoom);
            }
            if (!availableRooms.isEmpty()) {
                MeetingRoom meetingRoom = availableRooms.poll();
                bookingsInRoom[meetingRoom.getRoom()]++;
                meetingRoom.meetingEndTime = currentEndTime;
                usedRooms.offer(meetingRoom);
            } else {
                MeetingRoom earliestAvailableRoom = usedRooms.poll();
                bookingsInRoom[earliestAvailableRoom.getRoom()]++;
                earliestAvailableRoom.meetingEndTime = Math.max(earliestAvailableRoom.meetingEndTime, currentStartTime) + (currentEndTime - currentStartTime);
                usedRooms.offer(earliestAvailableRoom);
            }
        }

        int maxBookings = 0;
        int roomWithMostBookings = -1;
        for (int i = 0; i < n; i++) {
            if (bookingsInRoom[i] > maxBookings) {
                maxBookings = bookingsInRoom[i];
                roomWithMostBookings = i;
            }
        }
        return roomWithMostBookings;
    }

    class MeetingRoom {

        int room;
        long meetingEndTime;

        public MeetingRoom(int room, int meetingEndTime) {
            this.room = room;
            this.meetingEndTime = meetingEndTime;
        }

        int getRoom() {
            return this.room;
        }

        long getMeetingEndTime() {
            return this.meetingEndTime;
        }

    }

}