/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    } 
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int dp_0 = 0, dp_1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1);
            dp_1 = temp + nums[i];
        }
        return Math.max(dp_0, dp_1);
    } 
}
// @lc code=end

