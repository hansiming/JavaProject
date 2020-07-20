package com.cszjo.leetcode.array;

public class Solution79 {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    if (exists(board, i, j, 0, chars)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int i, int j, int index,
                           char[] arr) {

        if (index == arr.length - 1 && board[i][j] == arr[index]) {
            return true;
        }

        if (board[i][j] != arr[index]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = ',';

        if (i > 0) {
            if (exists(board, i - 1, j, index + 1, arr)) {
                return true;
            }
        }

        if (i < board.length - 1) {
            if (exists(board, i + 1, j, index + 1, arr)) {
                return true;
            }
        }

        if (j > 0) {
            if (exists(board, i, j - 1, index + 1, arr)) {
                return true;
            }
        }

        if (j < board[0].length - 1) {
            if (exists(board, i, j + 1, index + 1, arr)) {
                return true;
            }
        }

        board[i][j] = tmp;

        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}};
//        boolean abcced = new Solution79().exist(board, "ABCCED");
        char[][] board = {{'a'}};
        boolean aaa = new Solution79().exist(board, "a");
        System.out.println(aaa);
    }
}
