package com.world.dfs;

public class MinimumnPathSum {

    // 这个 其实等价 于 二叉树
    // dp[i][j] = min( dp[i-1][j], dp[i][j-1] ) + grid[i][j]

    // 从(0,0)开始，是bottom-up方式调用的

    int dfs1(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        // bottom-up 调用
        // 所以是 i+1, 而不是 i-1
        if (i < m && j < n) {
            int r1 = dfs1(grid, i + 1, j) + grid[i][j];
            int r2 = dfs1(grid, i, j + 1) + grid[i][j];

            return Math.min(r1, r2);
        }

        if (i < m) {
            return dfs1(grid, i + 1, j) + grid[i][j];
        }

        if (j < n) {
            return dfs1(grid, i, j + 1) + grid[i][j];
        }

        return 0;
    }

    // 这个 其实等价 于 二叉树
    // dp[i][j] = min( dp[i-1][j], dp[i][j-1] ) + grid[i][j]

    // 从(m-1,n-1)开始，是bottom-up方式调用的

    int dfs2(int[][] grid, int i, int j) {

        // int m = grid.length;
        // int n = grid[0].length;

        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        // bottom-up 调用
        // 所以是 i+1, 而不是 i-1
        if (i >= 0 && j >= 0) {
            int r1 = dfs2(grid, i - 1, j) + grid[i][j];
            int r2 = dfs2(grid, i, j - 1) + grid[i][j];

            return Math.min(r1, r2);
        }

        if (i >= 0) {
            return dfs2(grid, i - 1, j) + grid[i][j];
        }

        if (j >= 0) {
            return dfs2(grid, i, j - 1) + grid[i][j];
        }

        return 0;
    }

    int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m][n];
    }

}
