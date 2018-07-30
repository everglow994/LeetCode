package DP;


import java.util.Arrays;
import java.util.List;

/**
 * Triangle: find a path from top to bottom with minimum sum, return that sum
 * Method: 1. Divide and conquer 2. DFS 3. DP
 */
public class Triangle {


    // method 1: bottom up dynamic programming
    public int dp(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int height = triangle.size();
        int width = triangle.get(height - 1).size();
        int[][] dp = new int[height + 1][width + 1];
        for(int i = height - 1; i >= 0; i--) {
            for(int j = i; j >=0; j--) {
                dp[i][j] = triangle.get(i).get(j) +
                        Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    // method 2: top down dynamic programming
    public int dpTopDown(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int height = triangle.size();
        int[][] dp = new int[height][height];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for(int i = 2; i < height; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) +
                        Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < height - 1; i++) {
            min = dp[height - 1][i] < min ? dp[height - 1][i] : min;
        }
        return min;
    }

    // method 3: divide and conquer with memorization
    public int dcMemo(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int[][] memo = new int[triangle.size()][triangle.size()];
        for(int[] arr: memo) Arrays.fill(arr, Integer.MAX_VALUE);
        return dc(triangle, 0, 0, memo);

    }

    public int dc(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        if(i == triangle.size()) return 0;
        if(memo[i][j] != Integer.MAX_VALUE) return memo[i][j];
        return triangle.get(i).get(j) + Math.min(dc(triangle, i + 1, j, memo), dc(triangle, i + 1, j + 1, memo));
    }


}


