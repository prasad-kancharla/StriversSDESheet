package com.prasad.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfCoins {

    public static void main(String[] args) {
        System.out.println(MinimumCoins(50));
    }

    public static List<Integer> MinimumCoins(int n) {
        List<Integer> minCoins = new ArrayList<>();
        int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int i = 0;
        while (n > 0) {
            if (coins[i] <= n) {
                n -= coins[i];
                minCoins.add(coins[i]);
            } else {
                i++;
            }
        }
        return minCoins;
    }

}
