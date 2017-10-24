package com.cszjo.offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *         则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *         行和列的个数可能不一样
 * Created by hansiming on 2017/10/24.
 */
public class Demo18 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = matrix.length;
        int circle = length / 2;

        for (int i = 0; i < circle; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i; j < length - 1 - i; j++) {
                result.add(matrix[j][length - 1 - i]);
            }
            for (int j = length - 1 - i; j > i; j--) {
                result.add(matrix[length - 1 - i][j]);
            }
            for (int j = length - 1 - i; j > i; j--) {
                result.add(matrix[j][i]);
            }
        }

        if (length % 2 == 1) {
            result.add(matrix[circle][circle]);
        }
        return result;
    }

    public ArrayList<Integer> printMatri(int [][] array) {

            ArrayList<Integer> result = new ArrayList<Integer> ();
            if(array.length==0) return result;
            int n = array.length,m = array[0].length;
            if(m==0) return result;
            int layers = (Math.min(n,m)-1)/2+1;//这个是层数
            for(int i=0;i<layers;i++){
                    for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
                    for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
                    for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
                    for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
                }
            return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(new Demo18().printMatrix(matrix));
    }
}
