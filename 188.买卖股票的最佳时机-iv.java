/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, temp - prices[i]);
        }
        return dp_0;
    }
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        
        int[][][] dp = new int[prices.length][k+1][2];


        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }
}
// @lc code=end

