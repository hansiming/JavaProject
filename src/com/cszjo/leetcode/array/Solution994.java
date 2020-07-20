package com.cszjo.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {

    public int orangesRotting(int[][] grid) {
        // bfs
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int[] rowAndCol = {i, j};
                    queue.offer(rowAndCol);
                }
            }
        }

        queue.offer(null);

        int count = 0;
        while (!queue.isEmpty()) {
            int[] rowAndCol = queue.poll();
            if (rowAndCol == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    count++;
                }
                continue;
            }
            if (rowAndCol[0] > 0 && grid[rowAndCol[0] - 1][rowAndCol[1]] == 1) {
                int[] cur = {rowAndCol[0] - 1, rowAndCol[1]};
                queue.offer(cur);
                grid[rowAndCol[0] - 1][rowAndCol[1]] = 2;
            }

            if (rowAndCol[0] < grid.length - 1 && grid[rowAndCol[0] + 1][rowAndCol[1]] == 1) {
                int[] cur = {rowAndCol[0] + 1, rowAndCol[1]};
                queue.offer(cur);
                grid[rowAndCol[0] + 1][rowAndCol[1]] = 2;
            }

            if (rowAndCol[1] > 0 && grid[rowAndCol[0]][rowAndCol[1] - 1] == 1) {
                int[] cur = {rowAndCol[0], rowAndCol[1] - 1};
                queue.offer(cur);
                grid[rowAndCol[0]][rowAndCol[1] - 1] = 2;
            }

            if (rowAndCol[1] < grid[0].length - 1 && grid[rowAndCol[0]][rowAndCol[1] + 1] == 1) {
                int[] cur = {rowAndCol[0], rowAndCol[1] + 1};
                queue.offer(cur);
                grid[rowAndCol[0]][rowAndCol[1] + 1] = 2;
            }
        }

        // 可以提前记录为1的个数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] martix = {{2,1,1},{1,1,0},{0,1,1}};
        new Solution994().orangesRotting(martix);
    }
}
