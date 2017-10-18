package com.cszjo.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by hansiming on 2017/10/18.
 */
public class Demo8 {

    private int count = 0;

    public int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int n2 = 1;
        int n1 = 2;
        int cur = 0;
        for (int i = 3; i <= target; i++) {
            cur = n1 + n2;
            n2 = n1;
            n1 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Demo8().JumpFloor(4));
    }
}
