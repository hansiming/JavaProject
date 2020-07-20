package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) throws Exception {
        System.out.println(new PascalsTriangle().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        int k = rowIndex;
        if (k == 0) return Arrays.asList(1);
        else if (k == 1) return Arrays.asList(1, 1);
        else if (k == 2) return Arrays.asList(1, 2, 1);
        List<Integer> result = new ArrayList<>();
        result.add(2);
        k = k - 2;
        int p, c;
        while (k-- > 0) {
            p = 1;
            int i = 0;
            for (int l = result.size(); i < l; i++) {
                c = result.get(i);
                result.set(i, p + c);
                p = c;
            }
            result.add(p + 1);
        }
        result.add(0, 1);
        result.add(1);
        return result;
    }
}
