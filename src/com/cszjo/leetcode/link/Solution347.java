package com.cszjo.leetcode.link;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> q =
                new PriorityQueue<>((m1, m2) ->
                                            frequencyForNum.get(m2) - frequencyForNum.get(m1));

        for (int num : frequencyForNum.keySet()) {
            q.offer(num);
        }

        int size = Math.min(k, q.size());
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        new Solution347().topKFrequent(arr, 2);
    }
}
