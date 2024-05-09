package com.prasad.companies.apple;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/
class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int count = 0;

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

}