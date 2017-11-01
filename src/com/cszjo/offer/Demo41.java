package com.cszjo.offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * Created by hansiming on 2017/11/1.
 */
public class Demo41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2)
            return result;
        int low = 0;
        int high = array.length - 1;
        while (array[low] < (sum + 1) /2) {
            int tmp = array[low] + array[high];
            if (tmp == sum) {
                result.add(array[low]);
                result.add(array[high]);
                break;
            } else if (tmp > sum)
                high--;
            else
                low++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        System.out.println(new Demo41().FindNumbersWithSum(arr, 15));
    }
}
