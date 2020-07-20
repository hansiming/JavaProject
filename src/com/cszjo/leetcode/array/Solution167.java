package com.cszjo.leetcode.array;

public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int cur = numbers[start] + numbers[end];
            if (cur > target) {
                end--;
            } else if (cur < target) {
                start++;
            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        new Solution167().twoSum(numbers, target);
    }
}
