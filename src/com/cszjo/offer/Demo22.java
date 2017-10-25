package com.cszjo.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * Created by hansiming on 2017/10/25.
 */
public class Demo22 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return checkSquence(sequence, 0, sequence.length);
    }

    public boolean checkSquence (int[] sequence, int start, int end) {
        if (start >= end - 1)
            return true;
        int i = end - 1;
        while (i >= 1 && sequence[i - 1] > sequence[end - 1]) {
            i--;
        }
        for (int n = start; n < i; n++) {
            if (sequence[n] > sequence[end - 1])
                return false;
        }
        return checkSquence(sequence, start, i) && checkSquence(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] s = {5,4,3,2,1};
        System.out.println(new Demo22().VerifySquenceOfBST(s));
    }
}
