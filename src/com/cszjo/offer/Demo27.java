package com.cszjo.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * Created by hansiming on 2017/10/27.
 */
public class Demo27 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null)
            return 0;
        int cur = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                cur = array[i];
                count++;
                continue;
            }
            if (cur == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (cur == array[i]) {
                count++;
            }
        }

        return count <= (array.length / 2) ? 0 : cur;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,2,5,2,3};
        System.out.println(new Demo27().MoreThanHalfNum_Solution(arr));
    }
}
