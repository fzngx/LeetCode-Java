/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][11000];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (i == 0) {
                    dp[i][j] = j == nums[i];
                    continue;
                }
                if (j < nums[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }

            }
        }
        return dp[n-1][sum/2];
    }
}
// @lc code=end

