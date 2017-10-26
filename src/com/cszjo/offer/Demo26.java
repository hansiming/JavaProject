package com.cszjo.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * Created by hansiming on 2017/10/26.
 */
public class Demo26 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null)
            return result;
        permutation(result, str.toCharArray(), 0);
        Collections.sort(result);
        return result;
    }

    public void permutation(ArrayList<String> result, char[] arr, int target) {
        if (target == arr.length - 1) {
            String tmp = String.valueOf(arr);
            if (!result.contains(tmp))
                result.add(tmp);
            return;
        }
        for (int i = target; i < arr.length; i++) {
            swap(arr, target, i);
            permutation(result, arr, target + 1);
            swap(arr, target, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Demo26().Permutation("abc"));
    }
}
