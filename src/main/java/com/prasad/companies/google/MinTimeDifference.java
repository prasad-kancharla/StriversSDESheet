package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinTimeDifference {
//    public int findMinDifference(List<String> timePoints) {
//        Collections.sort(timePoints, (t1, t2) -> {
//            String[] t1Details = t1.split(":");
//            String[] t2Details = t2.split(":");
//            int t1Hours = Integer.parseInt(t1Details[0]);
//            int t2Hours = Integer.parseInt(t2Details[0]);
//            if (t1Hours != t2Hours) {
//                return t1Hours - t2Hours;
//            } else {
//                int t1Mins = Integer.parseInt(t1Details[1]);
//                int t2Mins = Integer.parseInt(t2Details[1]);
//                return t1Mins - t2Mins;
//            }
//        });
//
//        int minMinutesDiff = Integer.MAX_VALUE;
//        int size = timePoints.size();
//
//        for (int i = 1; i < size; i++) {
//            String[] t1Details = timePoints.get(i - 1).split(":");
//            String[] t2Details = timePoints.get(i).split(":");
//            int t1Hours = Integer.parseInt(t1Details[0]);
//            int t2Hours = Integer.parseInt(t2Details[0]);
//            int t1Mins = Integer.parseInt(t1Details[1]);
//            int t2Mins = Integer.parseInt(t2Details[1]);
//
//            int diffHours = (t2Hours - t1Hours);
//            int diffMins = (t2Mins - t1Mins);
//            if (t1Hours == 0 && t2Hours == 23) {
//                diffHours = 0;
//                diffMins = 60 - t2Mins + t1Mins;
//            }
//
//            int minutesDiff = diffHours * 60 + diffMins;
//            minMinutesDiff = Math.min(minutesDiff, minMinutesDiff);
//        }
//
//        return minMinutesDiff;
//    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("23:59");
        input.add("00:00");
        System.out.println(new MinTimeDifference().findMinDifference(input));
    }

    public int findMinDifference(List<String> timePoints) {
        // Convert time strings to minutes
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            minutesList.add(minutes);
        }

        // Sort the list of minutes
        Collections.sort(minutesList);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutesList.size(); i++) {
            minDiff = Math.min(minDiff, minutesList.get(i) - minutesList.get(i - 1));
        }

        // Compare the last and first time to handle circular case (e.g., 23:59 and 00:00)
        int circularDiff = 1440 + minutesList.get(0) - minutesList.get(minutesList.size() - 1);
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }
}