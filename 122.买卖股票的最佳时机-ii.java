/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
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
    }
}
// @lc code=end

