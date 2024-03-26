package com.prasad.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumActivities {

    public static void main(String[] args) {
        List<Integer> start = List.of(1, 1, 1);
        List<Integer> end = List.of(4,5,9);
        System.out.println(maximumActivities(start, end));
    }

    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        int n = start.size();
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start.get(i), end.get(i)));
        }
        Collections.sort(activities, Comparator.comparingInt(a -> a.end));
        int prevActivityEndTime = activities.get(0).end;
        int maxActivitiesCount = 1;

        for (int i = 1; i < n; i++) {
            Activity activity = activities.get(i);
            if (activity.start >= prevActivityEndTime) {
                maxActivitiesCount++;
                prevActivityEndTime = activity.end;
            }
        }

        return maxActivitiesCount;
    }

    static class Activity {

        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

}