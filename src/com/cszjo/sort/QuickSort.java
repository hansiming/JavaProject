package com.cszjo.sort;

public class QuickSort {

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int part = partition(arr, start, end);
        quickSort(arr, start, part - 1);
        quickSort(arr, part + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int tmp = arr[start];
        while (start < end) {
            while (arr[end] > tmp && start < end) {
                end--;
            }

            if (start < end) {
                arr[start] = arr[end];
            }

            while (arr[start] < tmp && start < end) {
                start++;
            }

            if (start < end) {
                arr[end] = arr[start];
            }
        }
        arr[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,5,1};
        new QuickSort().quickSort(arr, 0, 4);
        System.out.println(arr);
    }
}
