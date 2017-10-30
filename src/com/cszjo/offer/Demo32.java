package com.cszjo.offer;

import java.util.ArrayList;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * Created by hansiming on 2017/10/30.
 */
public class Demo32 {
    public int GetUglyNumber_Solution(int index) {

        if (index <= 0)
            return 0;
        if (index == 1)
            return 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i1 = 0, i2 = 0, i3 = 0;
        while (list.size() < index) {
            int m1 = list.get(i1) * 2;
            int m2 = list.get(i2) * 3;
            int m3 = list.get(i3) * 5;
            int tmp = Math.min(Math.min(m1, m2), m3);
            if (m1 == tmp)
                i1++;
            if (m2 == tmp)
                i2++;
            if (m3 == tmp)
                i3++;
            list.add(tmp);
        }
        return list.get(index - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Demo32().GetUglyNumber_Solution(6));
    }
}
