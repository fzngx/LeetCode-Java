/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int res = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[res - 2]) nums[res++] = nums[i];
        }
        return res;
    }
}
// @lc code=end

