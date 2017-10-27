package com.cszjo.offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Created by hansiming on 2017/10/27.
 */
public class Demo28 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null)
            return result;
        if (k > input.length)
            return result;
        adjustMaxHeap(input, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                swap(input, i, 0);
                adjustMaxHeap(input, k);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private void adjustMaxHeap(int[] input, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            if (i * 2 + 2 < length) {
                if (input[i * 2 + 1] < input[i * 2 + 2]) {
                    swap(input, i * 2 + 1, i * 2 + 2);
                }
            }
            if (input[i] < input[i * 2 + 1]) {
                swap(input, i, i * 2 + 1);
            }
        }
    }

    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        new Demo28().GetLeastNumbers_Solution(arr, 4);
    }
}
