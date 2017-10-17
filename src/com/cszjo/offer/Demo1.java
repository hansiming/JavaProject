package com.cszjo.offer;

/**
 * Created by hansiming on 2017/9/11.
 */
public class Demo1 {

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
     */
    public boolean Find(int target, int [][] array) {

        int row = 0;
        int col = array[0].length - 1;

        while (row <= array.length - 1 && col >= 0) {
            if (array[row][col] == target)
                return true;
            else if (array[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
