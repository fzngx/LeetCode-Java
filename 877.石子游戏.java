/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
      /*public boolean stoneGame(int[] piles) {
        return true;
    }*/

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int t1 = dp[i + 1][j][1] + piles[i];
                int t2 = dp[i][j - 1][1] + piles[j];
                if (t1 > t2) {
                    dp[i][j][0] = t1;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = t2;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][n-1][0] > dp[0][n-1][1];
    }
}
// @lc code=end

