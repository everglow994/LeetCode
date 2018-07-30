package DP;

public class PalindromeSubstrings {

    // 1. dynamic programming
    // time: O(N^2)
    // space: O(N^2)
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();

        // dp(i, j) represent substring from (i to j) is palindrome or not
        boolean[][] dp = new boolean[len][len];

        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j || dp[i + 1][j - 1]);
            }
        }

        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) if(dp[i][j]) count++;
        }

        return count;
    }


    // 2.

}
