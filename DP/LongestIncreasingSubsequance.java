package DP;

import java.util.Arrays;

/**
 * star problem
 * method: dynamic programming
 */

public class LongestIncreasingSubsequance {
    public int dp(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x: dp) max = Math.max(max, x);
        return max;
    }
}
