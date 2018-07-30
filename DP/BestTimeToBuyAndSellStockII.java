package DP;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int N = prices.length;
        int[] dp = new int[N];

        // strategy:
        // sell at the most expensive day if keep increasing
        // if price drop, waiting for the lowest price to buy again
        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);

        }
        return dp[N - 1];
    }
}
