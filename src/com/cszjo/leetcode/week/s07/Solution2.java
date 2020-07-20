package com.cszjo.leetcode.week.s07;

import java.util.Arrays;
import java.util.Map;

public class Solution2 {

    public int sumFourDivisors(int[] nums) {

        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int dCount = 2;
            int target = 1 + num;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    if (num / j == j) {
                        dCount++;
                        target += j;
                    } else {
                        dCount += 2;
                        target += j;
                        target += (num / j);
                    }
                }

                if (dCount > 4) {
                    break;
                }
            }

            if (dCount == 4) {
                res += target;
            }
        }

        return res;
    }


//    public int sumFourDivisors(int[] nums) {
//
//        int res = 0;
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//
//        Arrays.sort(nums);
//
//
//
//        if (nums[nums.length - 1] <= 3) {
//            return 0;
//        }
//
//        int[] dp = new int[nums[nums.length - 1] + 1];
//        int[] count = new int[nums[nums.length - 1] + 1];
//
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        count[1] = 1;
//        count[2] = 2;
//        count[3] = 2;
//
//        for (int i = 4; i < dp.length; i++) {
//
//            for (int j = 2; j <= i / 2; j++) {
//                if (i % j == 0) {
//                    dp[i] += dp[j];
//                    count[i] += count[j];
//                }
//            }
//            dp[i] += i;
//            count[i] += 1;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (count[nums[i]] == 4) {
//                res += dp[nums[i]] + 1;
//            }
//        }
//
//        return res;
//    }

//    public int sumFourDivisors(int[] nums) {
//
//        int res = 0;
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (max < nums[i]) {
//                max = nums[i];
//            }
//        }
//
//        if (max <= 5) {
//            return 0;
//        }
//
//        int[] dp = new int[max + 1];
//        int[] count = new int[max + 1];
//
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        dp[4] = 6;
//        dp[5] = 5;
//        count[1] = 1;
//        count[2] = 1;
//        count[3] = 1;
//        count[4] = 2;
//        count[5] = 1;
//
//        for (int i = 6; i < dp.length; i++) {
//
//            int cur = i;
//            count[i] = 1;
//            dp[i] = i;
//            boolean flag2 = false;
//            while (cur != 1) {
//                if (flag2) {
//                    if (cur == 2 || cur == 3 || cur == 5) {
//                        break;
//                    }
//                    count[i] ++;
//                    dp[i] += dp[cur];
//                    break;
//                }
//                if (cur % 2 != 0 && cur % 5 != 0 && cur % 3 != 0) {
//                    break;
//                }
//                if (cur % 2 == 0) {
//                    dp[i] += dp[2];
//                    count[i]++;
//                    cur/=2;
//                }
//
//                if (cur % 5 == 0) {
//                    dp[i] += dp[5];
//                    count[i]++;
//                    cur/=5;
//                }
//
//                if (cur % 3 == 0) {
//                    dp[i] += dp[3];
//                    count[i]++;
//                    cur/=3;
//                }
//
//                flag2 = true;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (count[nums[i]] == 3) {
//                res += dp[nums[i]];
//                dp[nums[i]] += 1;
//            }
//        }
//
//        return res + 1;
//    }

    public static void main(String[] args) {
        int[] nums  = {21,21};
        int i = new Solution2().sumFourDivisors(nums);
        System.out.println(i);
    }
}
