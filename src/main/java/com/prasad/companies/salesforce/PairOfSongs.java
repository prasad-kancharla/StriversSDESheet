package com.prasad.companies.salesforce;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
public class PairOfSongs {

    public static void main(String[] args) {
        int[] input = {15, 63, 451, 213, 37, 209, 343, 319};
        System.out.println(new PairOfSongs().numPairsDivisibleBy60(input));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int[] rem = new int[60];
        for (int i = 0; i < n; i++) {
            rem[time[i] % 60]++;
        }

        int pairsCount = 0;
        pairsCount += ((long) rem[0] * (long) (rem[0] - 1)) / 2;
        pairsCount += ((long) rem[30] * ((long) rem[30] - 1)) / 2;

        for (int i = 1; i <= 29; i++) {
            pairsCount += rem[i] * rem[60 - i];
        }
        return pairsCount;
    }

}
