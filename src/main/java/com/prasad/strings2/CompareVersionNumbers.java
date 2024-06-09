package com.prasad.strings2;

class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.0.0", "1.0"));
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[i]);
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            if (Integer.parseInt(arr1[i]) > 0) {
                return 1;
            }
            i++;
        }

        while (j < arr2.length) {
            if (Integer.parseInt(arr2[j]) > 0) {
                return -1;
            }
            j++;
        }
        return 0;
    }

}