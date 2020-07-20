package com.cszjo.sort2;

public class CombineSort {

    public void sort(int[] nums) {
        combine(nums, 0, nums.length - 1);
    }

    private void combine(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        combine(nums, start, mid);
        combine(nums, mid + 1, end);

        int[] arr = new int[end - start + 1];
        int inx1 = start, inx2 = mid + 1, curInx = 0;
        while (inx1 <= mid && inx2 <= end) {
            if (nums[inx1] < nums[inx2]) {
                arr[curInx++] = nums[inx1++];
            } else {
                arr[curInx++] = nums[inx2++];
            }
        }

        if (inx1 <= mid) {
            for (int i = inx1; i <= mid; i++) {
                arr[curInx++] = nums[i];
            }
        } else {
            for (int i = inx2; i <= end; i++) {
                arr[curInx++] = nums[i];
            }
        }

        System.arraycopy(arr, 0, nums, start, arr.length);
    }

    public static void main(String[] args) {

        int[] nums = {3,4,2,1,7};
        new CombineSort().sort(nums);
    }
}
