package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width
 * and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * example: [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelope {
    public int dp(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int N = envelopes.length;

        Arrays.sort(envelopes, Comparator.comparingInt(arr -> arr[0]));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int max = 1;       // please, think more carefully about the initial value always :(
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

