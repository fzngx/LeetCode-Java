/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    // Time Limit Exceeded
    /*
    public int dp(char[] s1, int i, char[] s2, int j) {
        if (i == -1 || j == -1) return 0;
        if (s1[i] == s2[j]) return 1 + dp(s1, i - 1, s2, j - 1);
        else {
            return Math.max(dp(s1, i - 1, s2, j), dp(s1, i, s2, j - 1));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        return dp(s1, text1.length() - 1, s2, text2.length() -1);
    }*/

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i -1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

