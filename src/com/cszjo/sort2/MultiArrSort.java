package com.cszjo.sort2;

import java.util.PriorityQueue;
import java.util.Queue;

public class MultiArrSort {

    private static class Cell {
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[] sort(int[][] nums) {
        Queue<Cell> q = new PriorityQueue<>((c1, c2) ->  c1.val - c2.val);
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            q.offer(new Cell(i, 0, nums[i][0]));
            length += nums[i].length;
        }

        int[] res = new int[length];
        int inx = 0;
        while (!q.isEmpty()) {
            Cell c = q.poll();
            res[inx++] = c.val;
            if (c.col < nums[c.row].length - 1) {
                c.col += 1;
                c.val = nums[c.row][c.col];
                q.offer(c);
            }
        }

        // LogM * N
        return res;
    }

    public static void main(String[] args) {

        int[][] nums = new int[5][];
        nums[0] = new int[]{3,4,2,5,6,7};

        nums[1] = new int[]{1,5,2,6,7,3,2};
        nums[2] = new int[]{23,4,3,6,7,1};
        nums[3] = new int[]{12,2,4,53,6,4};
        nums[4] = new int[]{1};

        new MultiArrSort().sort(nums);
    }
}
