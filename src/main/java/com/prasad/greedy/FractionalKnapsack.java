package com.prasad.greedy;

import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        Pair[] pairs2 = {
                new Pair(20, 12),
                new Pair(24, 35),
                new Pair(36, 41),
                new Pair(40, 25),
                new Pair(42, 32)
        };

        System.out.println(maximumValue(pairs2, 5, 200));

    }

    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (i1, i2) -> {
            double ratio1 = (double) i1.value / i1.weight;
            double ratio2 = (double) i2.value / i2.weight;
            return Double.compare(ratio2, ratio1);
        });
        double value = 0;
        int i = 0;
        while (w > 0 && i < n) {
            if (items[i].weight <= w) {
                w -= items[i].weight;
                value += items[i].value;
            } else {
                value += (double) (w) / (double) (items[i].weight) * (double) items[i].value;
                w = 0;
            }
            i++;
        }
        return value;
    }

    static class Pair {

        int weight;
        int value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

}
