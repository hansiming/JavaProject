package com.cszjo.offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * Created by hansiming on 2017/11/20.
 */
public class Demo42 {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 1)
            return str;
        if (n <= 0)
            return str;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo42().LeftRotateString("abcXYZdef", 3));
    }
}
