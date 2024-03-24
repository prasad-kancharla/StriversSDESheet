package com.prasad.greedy;

import java.util.Arrays;

public class MinPlatformsOptimal {

    public static void main(String[] args) {
        int[] start = {900, 940, 950, 1100, 1500, 1800};
        int[] end = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(calculateMinPlatforms(start, end, 6));
    }

    public static int calculateMinPlatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int platformCount = 1;
        int arrIndex = 1;
        int depIndex = 0;

        while (arrIndex < n && depIndex < n) {
            if (at[arrIndex] <= dt[depIndex]) {
                platformCount++;
            } else {
                depIndex++;
            }
            arrIndex++;
        }
        return platformCount;
    }

}