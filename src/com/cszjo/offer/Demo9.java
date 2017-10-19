package com.cszjo.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by hansiming on 2017/10/19.
 */
public class Demo9 {

    public int JumpFloorII(int target) {

        if (target <= 2)
            return target;

        return 2 * JumpFloorII(target - 1);
    }
}
