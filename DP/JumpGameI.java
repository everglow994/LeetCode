package DP;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGameI {
    public boolean dp(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[0] = true;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] >= i - j && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N - 1];
    }

    public boolean greedy(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int N = nums.length;
        int index = 0, gas = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] > gas) gas = nums[i];
            if (gas > 0) {
                index++;
            } else {
                break;
            }
            gas--;
        }
        return index > N - 1;
    }
}
