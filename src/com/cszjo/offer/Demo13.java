package com.cszjo.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Created by hansiming on 2017/10/20.
 */
public class Demo13 {

    public void reOrderArray(int [] array) {

        int[] tmpArr = new int[array.length];
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1)
                tmpArr[tmp++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0)
                tmpArr[tmp++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmpArr[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 3, 8, 6, 7, 9};
        new Demo13().reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
