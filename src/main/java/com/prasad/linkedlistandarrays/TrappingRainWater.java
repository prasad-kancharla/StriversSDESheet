package com.prasad.linkedlistandarrays;

class TrappingRainWater {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(input));
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] prefixHeightLeft = new int[n];
        int[] prefixHeightRight = new int[n];

        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < n; i++) {
            prefixHeightLeft[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            prefixHeightRight[i] = maxRight;
            maxRight = Math.max(maxRight, height[i]);
        }

        int totalWaterTrapped = 0;
        for (int i = 0; i < n; i++) {

            int waterTrapped = Math.min(prefixHeightRight[i], prefixHeightLeft[i]) - height[i];
            if (waterTrapped > 0) {
                totalWaterTrapped += waterTrapped;
            }

        }

        return totalWaterTrapped;
    }

}