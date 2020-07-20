package com.cszjo.leetcode.array;

public class Solution200 {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean dfs(char[][] grid, int x, int y) {
        if (!isIsland(grid, x, y)) {
            return false;
        }

        grid[x][y] = '2';

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);

        return true;
    }

    public boolean isIsland(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }
}
