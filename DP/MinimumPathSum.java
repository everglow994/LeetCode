package DP;


/**
 * method: Dynamic Programming
 * given minimum path sum of an matrix, from top left to bottom right, you can only move down or move to the right.
 */
public class MinimumPathSum {

    // method 1. dynamic programming O(MN) time, O(MN) space
    // dp[x, y] = Math.min(dp[x - 1, y], dp[x, y - 1]) + A[x, y];
    public int dp(int[][] grid) {
        if(grid == null || grid.length == 0) throw new IllegalArgumentException();
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }

            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
