package com.cszjo.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * Created by hansiming on 2017/10/31.
 */
public class Demo36 {

    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0)
            return 0;
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        return last - first + 1;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        if(start > end)
            return 0;
        int mid = (start + end) >> 1;
        if(array[mid] > k)
            return getFirstK(array, k, start, mid-1);
        else if (array[mid] < k)
            return getFirstK(array, k, mid+1, end);
        else if(mid-1 >=0 && array[mid-1] == k)
            return getFirstK(array, k, start, mid-1);
        else
            return mid;
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if(array[mid] > k)
            return getLastK(array, k, start, mid-1);
        else if (array[mid] < k)
            return getLastK(array, k, mid + 1, end);
        else if(mid+1 < array.length && array[mid+1] == k)
            return getLastK(array, k, mid + 1, end);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,4,5};
        System.out.println(new Demo36().GetNumberOfK(arr, 2));
    }
}









