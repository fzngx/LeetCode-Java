/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        boolean buy = false;
        int priceBought = 0;
        int profitA = 0;
        int profitB = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i] < prices[i + 1]) {
                priceBought = prices[i];
                buy = true;
            }
            while (buy && i+1 < prices.length && prices[i+1] >= prices[i]) i++;

            if (buy) {
                int profit = prices[i] - priceBought;
                if (profit > profitB) profitB = profit;
                if (profitB > profitA) {
                    int temp = profitA;
                    profitA = profitB;
                    profitB = temp;
                }
                buy = false;
            }
        }
        return profitA + profitB;
    }
}
// @lc code=end

