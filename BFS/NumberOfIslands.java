package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // bfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = '0';
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        while(!queue.isEmpty()) {
            int[] land = queue.poll();
            for(int i = 0; i < 4; i++) {
                int[] adj = {land[0] + dirX[i], land[1] + dirY[i]};
                if(inBound(grid, adj[0], adj[1]) && grid[adj[0]][adj[1]] == '1') {
                    queue.offer(adj);
                    grid[adj[0]][adj[1]] = '0';
                }
            }
        }
    }

    private boolean inBound(char[][] grid, int x, int y) {
        int xbound = grid.length;
        int ybound = grid[0].length;
        return !(x < 0 || y < 0 || x >= xbound || y >= ybound);
    }

    // dfs
    public int numIslandsII(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        grid[x][y] = '0';
        for(int i = 0; i < 4; i++) {
            int adjx = x + dirX[i];
            int adjy = y + dirY[i];
            if(inBound(grid, adjx, adjy) && grid[adjx][adjy] == '1') {
                dfs(grid, adjx, adjy);
            }
        }
    }
}
