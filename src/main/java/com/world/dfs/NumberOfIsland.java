package com.world.dfs;

import java.util.PriorityQueue;

public class NumberOfIsland {

    void dfs(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    void bfs(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(i);
        pq.offer(j);

        while (!pq.isEmpty()) {

            int x = pq.poll();
            int y = pq.poll();

            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }

            if (grid[x][y] != 1) {
                continue;
            }

            grid[i][j] = 0;

            pq.offer(x - 1);
            pq.offer(y);

            pq.offer(x + 1);
            pq.offer(y);

            pq.offer(x);
            pq.offer(y - 1);

            pq.offer(x);
            pq.offer(y + 1);
        }
    }

}
