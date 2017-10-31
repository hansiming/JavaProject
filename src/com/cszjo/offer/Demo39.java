package com.cszjo.offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * Created by hansiming on 2017/10/31.
 */
public class Demo39 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2)
            return;
        int tmp = 0;
        for (int a : array)
            tmp ^= a;
        int i = 0;
        while ((tmp & 1) == 0 && i < 32) {
            tmp >>= 1;
            i++;
        }
        for (int a : array) {
            if (((a >> i) & 1) == 1)
                num1[0] ^= a;
            else
                num2[0] ^= a;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        new Demo39().FindNumsAppearOnce(arr, new int[]{0}, new int[]{0});
    }
}
