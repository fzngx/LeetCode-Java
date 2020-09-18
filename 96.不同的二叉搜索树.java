/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    /* 
    //  卡特兰数：C_n = C(2n, n) / (n+1);
     public int numTrees(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * (n + i) / i;
        }
        res /= (n+1);
        return (int)res;
    } */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

