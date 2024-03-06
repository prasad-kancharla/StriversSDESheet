package com.prasad.arrays;

class StockBuyAndSell {

    public static void main(String[] args) {
        int[] input = {7, 6, 5, 4, 3, 1};
        System.out.println(new StockBuyAndSell().maxProfit(input));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] > minPrice) {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

}