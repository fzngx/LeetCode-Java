/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void swap(int[] nums, int b, int e) {
        while (b < e) {
            int temp = nums[b];
            nums[b] = nums[e];
            nums[e] = temp;
            b++; e--;
        }
    }
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        if (k > nums.length) k %= nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }
}
// @lc code=end

