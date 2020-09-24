/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int robHelper(int[] nums, int b, int e) {
        int dp_0 = 0, dp_1 = nums[b];
        for (int i = b + 1; i <= e; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1);
            dp_1 = temp + nums[i];
        }
        return Math.max(dp_0, dp_1);
    }
    public int rob(int nums[]) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), 
                robHelper(nums, 1, nums.length - 1));
    }
}
// @lc code=end

