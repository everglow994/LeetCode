package DP;

/**
 * method: Dynamic Programming
 * find all possible path from top left to bottom right if you can only move down or move to the right
 */
public class UniquePathsI {

    // method 1. dynamic programming
    // dp[x, y] = dp[x - 1, y] + dp[x, y - 1].
    public int dp(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
