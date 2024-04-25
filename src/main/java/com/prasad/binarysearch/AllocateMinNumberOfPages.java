package com.prasad.binarysearch;

public class AllocateMinNumberOfPages {

    public static void main(String[] args) {
        int[] time = {1, 2, 2, 3, 1};
        System.out.println(ayushGivesNinjaTest(3, 5, time));
    }

    public static long ayushGivesNinjaTest(int n, int m, int[] time) {
        long totalTime = 0;
        long start = 0;
        for (int i = 0; i < m; i++) {
            start = Math.max(start, time[i]);
            totalTime += time[i];
        }

        long end = totalTime;
        long ans = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (getDays(mid, time, n)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean getDays(long timePerDay, int[] time, int n) {
        int days = 1;
        long sum = 0;
        int m = time.length;
        for (int i = 0; i < m; i++) {
            sum += time[i];
            if (sum > timePerDay) {
                sum = time[i];
                days++;
            }
            if (days > n) {
                return false;
            }
        }
        return true;
    }

}