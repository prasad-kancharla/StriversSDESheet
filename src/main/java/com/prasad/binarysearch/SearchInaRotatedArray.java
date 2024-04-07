package com.prasad.binarysearch;

class SearchInaRotatedArray {

    public static void main(String[] args) {
        int[] arr = {11, 14, 19, 23, 27, -20, -14, -8, -4, 1, 2, 4, 7};
        System.out.println(new SearchInaRotatedArray().search(arr, 2));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int k = getPivot(nums, n - 1);
        if (target >= nums[0] && target <= nums[k]) {
            return binarySearch(nums, 0, k, target);
        }
        return binarySearch(nums, k + 1, n - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int getPivot(int[] nums, int n) {
        int first = nums[0];
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid + 1 <= n && mid - 1 >= 0 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] >= first) {
                start = mid + 1;
            } else if (nums[mid] < first) {
                end = mid - 1;
            }
        }
        return -1;
    }

}