package com.prasad.amazon;

public class FinalInstances {

    public static void main(String[] args) {
        int[] nums = {30, 5, 4, 8, 19, 89};
        System.out.println(new FinalInstances().finalInstances(5, nums));

    }

    public int finalInstances(int instances, int[] averageUtil) {
        int n = averageUtil.length;
        int i = 0;
        while (i < n) {
            if (averageUtil[i] > 60) {
                if (instances <= 100000000) {
                    instances = 2 * instances;
                }
                i += 11;
            } else if (averageUtil[i] < 25 && instances > 1) {
                instances = instances % 2 != 0 ? instances / 2 + 1 : instances / 2;
                i += 11;
            } else {
                i++;
            }
        }
        return instances;
    }

}
