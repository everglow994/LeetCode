package DP;


/**
 * dynamic programming
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    // dynamic programming
    // dp[i] = dp[i - 1] + dp[i - 2]
    // look out for i == 1, i == 0
    // as well as len == = and len == 1
    public int dp(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
