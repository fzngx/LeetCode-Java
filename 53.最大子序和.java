/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    /*
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum > ans) {
                ans = sum;
            }
            
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    } */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || dp[i - 1] < 0) {
                dp[i] = nums[i];
                
            } else {
                dp[i] = nums[i] + dp[i - 1];   
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }
}
// @lc code=end

