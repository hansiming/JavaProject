package com.cszjo.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * Created by hansiming on 2017/10/20.
 */
public class Demo12 {

    public double Power(double base, int exponent) {

        int tem = exponent < 0 ? -exponent : exponent;
        double curr = base;
        double result = 1.0;

        while (tem > 0) {
            if ((tem & 1) == 1)
                result *= curr;
            curr *= base;
            tem >>= 1;
        }
        return exponent < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Demo12().Power(6.0, 2));
    }
}
