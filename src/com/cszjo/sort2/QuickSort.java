package com.cszjo.sort2;

public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int cur = nums[end];
        while (start < end) {
            while (nums[start] <= cur && start < end) {
                start++;
            }
            if (start < end) {
//                swap(nums, start, end);
                nums[end--] = nums[start];
            }

            while (nums[end] > cur && start < end) {
                end--;
            }
            if (start < end) {
                nums[start++] = nums[end];
            }
        }
        nums[start] = cur;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,1,7};
        new QuickSort().quickSort(nums, 0, 4);
    }
}
