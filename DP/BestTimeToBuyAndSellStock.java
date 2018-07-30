package DP;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */
public class BestTimeToBuyAndSellStock {

    // brute force O(N^2)
    public int brute(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < i; j++) if(prices[i] > prices[j]) {
                max = Math.max(max, prices[i] - prices[j]);
            }
        }
        return max;
    }

    public int dp(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int N = prices.length;

        // define dp as the profit to sell stock at day i
        int[] dp = new int[N];
        int max = 0;
        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
