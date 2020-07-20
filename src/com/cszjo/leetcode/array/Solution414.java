package com.cszjo.leetcode.array;

public class Solution414 {

    public int thirdMax(int[] nums) {

        boolean isRewrite = false;
        long one = Long.MIN_VALUE;
        long two = Long.MIN_VALUE, three = Long.MIN_VALUE;

        for (int i : nums) {
            if (i >= one) {
                if (i == one) {
                    continue;
                }
                three = two;
                two = one;
                one = i;
            } else if (i >= two) {
                if (i == two) {
                    continue;
                }
                three = two;
                two = i;
            } else if (i >= three) {
                if (i == three) {
                    continue;
                }
                three = i;
            }
        }
        return three == Long.MIN_VALUE ? Integer.parseInt(String.valueOf(one))
                : Integer.parseInt(String.valueOf(three));
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        int i = new Solution414().thirdMax(nums);
        System.out.println(i);
    }
}
