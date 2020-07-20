package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length <= 1) {
            res.add(nums[0]);
            return res;
        }
        int ansA = Integer.MAX_VALUE;
        int ansB = Integer.MAX_VALUE;
        int ansACount = 0;
        int ansBCount = 0;

        for (int n : nums) {
            if (n == ansA) {
                ansACount++;
                continue;
            }

            if (n == ansB) {
                ansBCount++;
                continue;
            }

            if (ansACount == 0) {
                ansA = n;
                ansACount++;
                continue;
            }

            if (ansBCount == 0) {
                ansB = n;
                ansBCount++;
                continue;
            }

            ansACount--;
            ansBCount--;
        }

        if (ansACount != 0) {
            ansACount = 0;
            for (int n : nums) {
                if (n == ansA) {
                    ansACount++;
                }
            }
        }

        if (ansBCount != 0) {
            ansBCount = 0;
            for (int n : nums) {
                if (n == ansB) {
                    ansBCount++;
                }
            }
        }

        if (ansACount > nums.length / 3) {
            res.add(ansA);
        }

        if (ansBCount > nums.length / 3) {
            res.add(ansB);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        List<Integer> integers = new Solution229().majorityElement(nums);
        System.out.println(integers);
    }
}
