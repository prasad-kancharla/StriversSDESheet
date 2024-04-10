package com.prasad.binarysearch;

public class GetCeilAndFloor {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      int[] ans = new int[2];
      ans[0] = getFloor(a, n, x);
      ans[1] = getCeil(a,n,x);
      return ans;
    }

    private static int getCeil(int[] a, int n, int x) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (a[mid] < x) {
                start = mid + 1;
            } else if (a[mid] > x) {
                end = mid - 1;
            } else {
                return a[mid];
            }
        }
        return start == n ? -1 : a[start];
    }

    private static int getFloor(int[] a, int n, int x) {
       int start = 0;
       int end = n - 1;
       while (start <= end) {
           int mid = start + (end - start)/2;
           if (a[mid] > x) {
               end = mid - 1;
           } else if (a[mid] < x){
               start = mid + 1;
           } else {
               return a[mid];
           }
       }
       return end == -1 ? -1 : a[end];
    }
    
}