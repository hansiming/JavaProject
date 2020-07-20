package com.cszjo.leetcode.week.s04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {

    Map<Integer, List<Integer>> all = new HashMap<>();

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 0) {
            return 0;
        }

        boolean[] flag = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!all.containsKey(edge[0])) {
                List<Integer> cur = new ArrayList<>();
                cur.add(edge[1]);
                all.put(edge[0], cur);
            } else {
                List<Integer> integers = all.get(edge[0]);
                integers.add(edge[1]);
            }

            if (!all.containsKey(edge[1])) {
                List<Integer> cur = new ArrayList<>();
                cur.add(edge[0]);
                all.put(edge[1], cur);
            } else {
                List<Integer> integers = all.get(edge[1]);
                integers.add(edge[0]);
            }
        }

        flag[0] = true;
        return recursion(all.get(1), 1,1, target, t, 1, flag);
    }

    private double recursion(List<Integer> cur, int curValue,
                             double curInx, int target, int t, int curT,
                             boolean[] flag) {

        if (curT > t) {
            return 0;
        }

        if (cur == null || cur.size() == 0) {
            if (curValue == target) {
                return curInx;
            } else {
                return 0;
            }
        }

        double curInx1 = (1 / (double) cur.size()) * curInx;
        if (curT == t) {
            if (cur.contains(target)) {
                return curInx1;
            } else {
                return 0;
            }
        }

        curInx = curInx1;

        for (int i = 0; i < cur.size(); i++) {
            Integer key = cur.get(i);
            List<Integer> input = all.get(key);
            input = getList(input, flag);
            flag[key - 1] = true;
            double recursion = recursion(input, key, curInx, target, t,
                                         curT + 1, flag);
            if (recursion != 0) {
                return recursion;
            }
            flag[key - 1] = false;
        }

        return 0;
    }

    private List<Integer> getList(List<Integer> input, boolean[] flag) {
        if (input == null) {
            return input;
        }
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (!flag[input.get(i) - 1]) {
                out.add(input.get(i));
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        int t = 20;
        int target = 4;
        double v = new Solution4().frogPosition(n, edges, t, target);
        System.out.println(v);
    }
}
