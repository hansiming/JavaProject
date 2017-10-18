package com.cszjo.offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * Created by hansiming on 2017/10/18.
 */
public class Demo7 {

    public int Fibonacci(int n) {

        if (n == 0)
            return 0;

        int pre = 1, cur = 1;
        for (int i = 2; i < n; i++) {
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Demo7().Fibonacci(5));
    }
}
