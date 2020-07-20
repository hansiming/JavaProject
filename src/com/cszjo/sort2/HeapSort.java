package com.cszjo.sort2;

public class HeapSort {

    public void sort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            adjustHeap(nums, i);
            swap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int end) {
        if (end == 0) {
            return;
        }
        int inx = (end - 1) / 2;
        for (; inx >= 0; inx--) {
            int left = inx * 2 + 1;
            int right = inx * 2 + 2;
            if (right <= end && nums[left] < nums[right]) {
                swap(nums, left, right);
            }
            if (nums[inx] < nums[left]) {
                swap(nums, inx, left);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,1,7};
        new HeapSort().sort(nums);
    }
}
