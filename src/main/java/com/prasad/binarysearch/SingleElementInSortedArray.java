package com.prasad.binarysearch;

import java.util.List;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        List<Integer> arr = List.of(10, 10, 14, 16, 16, 25, 25, 28, 28, 36, 36, 44, 44);
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(List<Integer> arr) {
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }
        if (!arr.get(0).equals(arr.get(1))) {
            return arr.get(0);
        }
        if (!arr.get(n - 1).equals(arr.get(n - 2))) {
            return arr.get(n - 1);
        }

        int start = 1; // no edge cases
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (!arr.get(mid).equals(arr.get(mid - 1)) && !arr.get(mid).equals(arr.get(mid + 1))) {
                return arr.get(mid);
            }
            if ((mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1))) || (mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))) {
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return -1;
    }

}