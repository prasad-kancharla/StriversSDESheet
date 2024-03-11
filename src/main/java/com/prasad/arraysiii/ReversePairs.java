package com.prasad.arraysiii;

class ReversePairs {

    public static void main(String[] args) {
        int[] input = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(new ReversePairs().reversePairs(input));
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSortAndCountReversePairs(nums, 0, n - 1);
    }

    private int mergeSortAndCountReversePairs(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            int count1 = mergeSortAndCountReversePairs(nums, start, mid);
            int count2 = mergeSortAndCountReversePairs(nums, mid + 1, end);
            int count3 = mergeAndCountReversePairs(nums, start, mid, end);
            return count1 + count2 + count3;
        }
        return 0;
    }

    private int mergeAndCountReversePairs(int[] nums, int start, int mid, int end) {
        int n = end - start + 1;
        int[] temp = new int[n];

        int i = start;
        int j = mid + 1;

        int k = 0;

        int count3 = 0;
        while (i <= mid && j <= end) {
            if ((long) nums[i] > 2 * (long) nums[j]) {
                count3 += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        i = start;
        j = mid + 1;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int l = 0; l < n; l++) {
            nums[l + start] = temp[l];
        }
        return count3;
    }

}