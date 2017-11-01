package com.cszjo.offer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 初始化small=1，big=2;
 * small到big序列和小于sum，big++;大于sum，small++;
 * 当small增加到(1+sum)/2是停止
 * Created by hansiming on 2017/11/1.
 */
public class Demo40 {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1)
            return result;
        int low = 1;
        int high = 2;
        while (low < (sum + 1) /2) {
            int sumTmp = getSum(low, high);
            if (sumTmp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++)
                    list.add(i);
                result.add(list);
                high++;
            } else if (sumTmp < sum)
                high++;
            else
                low++;
        }
        return result;
    }

    private int getSum(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Demo40().FindContinuousSequence(100));
    }
}












