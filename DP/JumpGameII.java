package DP;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGameII {

    // Dynamic Programming O(N^2)
    public int dp(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) dp[i] = i;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[N - 1];
    }


    // Greedy O(N)
    public int greedy(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int farthest = 0, end = 0, step = 0;
        for(int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(i == end) {
                end = farthest;
                step++;
                if(end >= nums.length - 1) break;
            }
        }
        return step;
    }
}
