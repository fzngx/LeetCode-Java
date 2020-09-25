/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
        /*
    public static int dp(int K, int N, int[][] memo) {
        if (N == 0) return 0;
        if (K == 1) return N;
        if (memo[K][N] != -1) return memo[K][N];

        int res = Integer.MAX_VALUE;

        int lo = 1, hi = N;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int broken = dp(K - 1, mid - 1, memo);
            int not_broken = dp(K, N - mid, memo);
            if (broken > not_broken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, not_broken + 1);
            }
        }
        memo[K][N] = res;
        return res;
    }
    public static int superEggDrop(int K, int N) {
        int[][] memo = new int[N+1][N+1];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        return dp(Math.min(K, N), N, memo);
    } */
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N + 1];

        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1;
            }
        }
        return m;
    }
}
// @lc code=end

