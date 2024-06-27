package com.prasad.companies.google;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
class MomentEveryoneBecameFriends {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
        UnionSet unionSet = new UnionSet(n);
        int length = logs.length;
        int groupCount = n;

        for (int i = 0; i < length; i++) {
            if (unionSet.addFriendship(logs[i][1], logs[i][2])) {
                groupCount--;
            }
            if (groupCount == 1) {
                return logs[i][0];
            }

        }
        return -1;
    }

    class UnionSet {

        private int[] group;
        private int[] rank;

        public UnionSet(int size) {
            group = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                group[i] = i;
                rank[i] = 1;
            }
        }

        public int findGroup(int person) {
            if (group[person] == person) {
                return group[person];
            }
            group[person] = findGroup(group[person]);
            return group[person];
        }

        public boolean areFriends(int person1, int person2) {
            return findGroup(person1) == findGroup(person2);
        }

        public boolean addFriendship(int person1, int person2) {
            int group1 = findGroup(person1);
            int group2 = findGroup(person2);
            if (group2 != group1) {
                if (rank[group1] > rank[group2]) {
                    group[group2] = group1;
                } else if (rank[group2] > rank[group1]) {
                    group[group1] = group2;
                } else {
                    group[group2] = group1;
                    rank[group1]++;
                }
                return true;
            }
            return false;
        }

    }

}