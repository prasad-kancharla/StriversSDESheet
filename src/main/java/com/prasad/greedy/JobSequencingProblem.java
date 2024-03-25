package com.prasad.greedy;

import java.util.Arrays;

public class JobSequencingProblem {

    public static void main(String[] args) {
        int[][] jobs = {
                {1, 2, 728},
                {2, 2, 857},
                {3, 4, 918},
                {4, 1, 679},
                {5, 1, 340}
        };

        System.out.println(jobScheduling(jobs));
    }

    public static int[] jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (job1, job2) -> job2[2] - job1[2]);
        int n = jobs.length;
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }

        int[] result = new int[maxDeadline + 1];
        for (int i = 0; i < maxDeadline + 1; i++) {
            result[i] = -1;
        }

        int countJobs = 0;
        int profit = 0;

        for (int i = 0; i < n; i++) {
            int deadline = jobs[i][1];
            for (int j = deadline; j > 0 ; j--) {
                if (result[j] == -1) {
                    result[j] = jobs[i][0];
                    profit += jobs[i][2];
                    countJobs++;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = profit;
        return ans;
    }

}
