package com.prasad.companies.servicenow;

import java.util.Arrays;

class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        int[] prefixProduct = new int[n];
        int[] postfixProduct = new int[n];
        int prev = 1;
        int post = 1;

        for (int i = 0; i < n; i++) {
            prefixProduct[i] = prev * nums[i];
            prev = prefixProduct[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            postfixProduct[i] = post * nums[i];
            post = postfixProduct[i];
        }

        for (int i = 0; i < n; i++) {
            int num1 = i == 0 ? 1 : prefixProduct[i - 1];
            int num2 = i == n - 1 ? 1 : postfixProduct[ i + 1];
            products[i] = num1 * num2;
        }

        return products;
    }

}