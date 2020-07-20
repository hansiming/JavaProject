package com.cszjo.leetcode.array;

public class Solution287 {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

//        int slow = 0;
//        int fast = 0;
//        slow = nums[slow];
//        fast = nums[nums[fast]];
//        while(slow != fast){
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        }
//        int pre1 = 0;
//        int pre2 = slow;
//        while(pre1 != pre2){
//            pre1 = nums[pre1];
//            pre2 = nums[pre2];
//        }
//        return pre1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        new Solution287().findDuplicate(nums);
    }
}
