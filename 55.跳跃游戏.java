/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public static boolean canJump(int[] nums) {
        int i , far = 0;
        for (i = 0;i < nums.length - 1; i++) {
            if (i + nums[i] > far) far = i + nums[i];
            if (far > nums.length - 1) return true;
            if (i + 1 > far) return false;
        }
        if (i < nums.length - 1) return false;
        return true;
    }
}
// @lc code=end

