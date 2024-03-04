package com.prasad.arrays;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n  = nums.length;
        int index = - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverserArray(0, n - 1, nums);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverserArray(index + 1, n - 1, nums);
    }

    private void reverserArray(int start, int end, int[] nums) {
        int i = start;
        int j = end;

        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}