package com.prasad.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinPlatformsBrueForce {

    public static void main(String[] args) {
        int[] start = {900, 940, 950, 1100, 1500, 1800};
        int[] end = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(calculateMinPlatforms(start, end, 6));
    }

    public static int calculateMinPlatforms(int at[], int dt[], int n) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(at[i], dt[i]));
        }
        Comparator<Pair> pairComparator = (p1, p2) -> p1.arrivalTime < p2.arrivalTime ? -1 : p1.arrivalTime > p2.arrivalTime ? 1 : 0;
        Collections.sort(pairs, pairComparator);

        int totalPlatforms = 1;
        Queue<Integer> departureTimes = new PriorityQueue<>();
        departureTimes.offer(pairs.get(0).departureTime);

        for (int i = 1; i < n; i++) {
            if (pairs.get(i).arrivalTime <= departureTimes.peek()) {
                totalPlatforms++;
            } else {
                departureTimes.remove();
            }
            departureTimes.offer(pairs.get(i).departureTime);
        }
        return totalPlatforms;
    }

    static class Pair {

        int arrivalTime;
        int departureTime;

        Pair(int arrivalTime, int departureTime) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

    }

}