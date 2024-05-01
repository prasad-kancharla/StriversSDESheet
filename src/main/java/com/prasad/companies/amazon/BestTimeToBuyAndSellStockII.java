package com.prasad.companies.amazon;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5};
        System.out.println(getMaximumProfit(5, arr));
    }

    public static long getMaximumProfit(int n, long[] values) {
        long totalProfit = 0;

        int i = 0;
        boolean buy = false;
        long buyingPrice = 0;
        while (i < n - 1) {
            if (!buy && values[i] < values[i + 1]) {
                buyingPrice = values[i];
                buy = true;
            }
            if (buy && values[i] > values[i + 1]) {
                totalProfit += values[i] - buyingPrice;
                buy = false;
            }
            i++;
        }
        if (buy) {
            totalProfit += values[n - 1] - buyingPrice;
        }
        return totalProfit;
    }

}
