/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if  (nums[i] < nums[i + 1] && nums[i] < nums[i + 2] && nums[i + 1] < nums[i+2]) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

