package com.cszjo.offer;

import java.util.LinkedHashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * Created by hansiming on 2017/10/30.
 */
public class Demo33 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.trim().equals(""))
            return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int i = 0;
        for (char c : arr) {
            if (map.get(c) == 1) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Demo33().FirstNotRepeatingChar("\"\""));
    }
}
