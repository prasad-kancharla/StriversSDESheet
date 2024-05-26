package com.prasad.companies.amazon;

class Candy {

    public static void main(String[] args) {
        int[] ratings = {5, 4, 3, 5, 6, 2};
        System.out.println(new Candy().candy(ratings));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        return totalCandies;
    }

}