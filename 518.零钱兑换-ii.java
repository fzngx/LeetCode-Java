/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0) + dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }
}
// @lc code=end

