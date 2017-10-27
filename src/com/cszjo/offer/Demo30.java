package com.cszjo.offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * http://www.cnblogs.com/cyjb/p/digitOccurrenceInRegion.html
 * Created by hansiming on 2017/10/27.
 */
public class Demo30 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int cur, pre, next;
        for (int i = 1; i <= n; i*=10) {
            cur = (n / i) % 10;
            pre = n / (i * 10);
            next = n - (n / i) * i;
            if (cur > 1)
                count += (pre + 1) * i;
            else if (cur == 1)
                count += (next + pre * i + 1);
            else
                count += pre * i;
        }
        return count;
    }

    public static void main(String[] args) {
        new Demo30().NumberOf1Between1AndN_Solution(13);
    }
}
