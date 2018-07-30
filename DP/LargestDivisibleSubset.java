package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers,
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * nums: [1,2,3]
 *
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * nums: [1,2,4,8]
 *
 * Result: [1,2,4,8]
 */
public class LargestDivisibleSubset {


    // can be seen as longest divisible sequence if first sorted

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        int N = nums.length, max = 1;
        int[] dp = new int[N];     // dp[i] represent LDS including ith element
        Arrays.fill(dp, 1);
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }

        }
        for(int i = N - 1; i >= 0; i--) {
            if(dp[i] == max) {
                if(ans.size() == 0) {
                    ans.add(nums[i]);
                    max--;
                } else if(ans.get(ans.size() - 1) % nums[i] == 0) {
                    ans.add(nums[i]);
                    max--;
                }
            }
        }
        return ans;
    }
}

