package com.cszjo.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * Created by hansiming on 2017/10/30.
 */
public class Demo31 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null)
            return null;
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (Integer.parseInt(o1 + o2) >= Integer.parseInt(o2 + o1)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String tmp : arr) {
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {321, 3, 32};
        new Demo31().PrintMinNumber(arr);
    }
}
