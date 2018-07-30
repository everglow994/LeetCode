package DP;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length == 0) return 0;
//        int N = prices.length;
//        int[] dp = new int[N];
//        for(int i = 1; i < N; i++) {
//            if(prices[i] > prices[i - 1]) {
//                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
//                dp[i - 1] = 0;
//            }
//        }
//        int max1 = 0, max2 = 0;
//        for(int i = 0; i < N; i++) {
//
//        }
//
//
//    }
}
