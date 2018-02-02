package com.cszjo.lintcode.easy._0116;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * Created by hansiming on 2018/1/16.
 */
public class Demo2 {

    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        return n / 5 + trailingZeros(n / 5);
    }

    public static void main(String[] args) {
        System.out.print(new Demo2().trailingZeros(11));
    }
}
