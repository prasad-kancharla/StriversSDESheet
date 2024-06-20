package com.prasad.companies.salesforce;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
class PairOfSongsBruteForce {

    public static void main(String[] args) {
        int[] input = {15,63,451,213,37,209,343,319};
        System.out.println(new PairOfSongsBruteForce().numPairsDivisibleBy60(input));
    }
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}