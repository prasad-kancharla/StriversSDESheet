package com.prasad.dynamicprogramming;

class MaximunIncreasingSumOptimal {

	public static void main(String[] args) {
		int[] arr = {1, 101, 2, 3, 100};
		System.out.println(new MaximunIncreasingSumOptimal().maxSumIS(arr, 5));
	}

	static int[][] dp;
    public int maxSumIS(int arr[], int n) {
        dp = new int[n][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return getMaxSum(arr, 0, -1);
    }

	private int getMaxSum(int[] arr, int index, int prevIndex) {
		if (index == arr.length) {
			return 0;
		}
		if (dp[index][prevIndex + 1] != -1) {
			return dp[index][prevIndex + 1];
		}

		// not take
		int ans1 = getMaxSum(arr, index + 1, prevIndex);

		// take
		int ans2 = Integer.MIN_VALUE;
		if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
			ans2 = arr[index] + getMaxSum(arr, index + 1, index);
		}
		dp[index][prevIndex + 1] = Math.max(ans1, ans2);

		return dp[index][prevIndex + 1];
	}

}