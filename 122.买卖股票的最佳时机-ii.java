/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    /*
    public int maxProfit(int[] prices) {
        int ans = 0;
        boolean buy = false;
        int priceBought = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i] < prices[i + 1]) {
                priceBought = prices[i];
                buy = true;
            }
            while (buy && i+1 < prices.length && prices[i+1] >= prices[i]) i++;

            if (buy) {
                ans += prices[i] - priceBought;
                buy = false;
            }
        }
        return ans;
    } */
    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp  - prices[i]);
        }
        return dp_i_0;
    }
}
// @lc code=end

