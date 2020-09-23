/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        int[] res = new int[2];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid;
            else if (target < nums[mid]) right = mid;
            else if (target > nums[mid]) left = mid + 1;
        }
        res[0] = (left < nums.length && nums[left] == target) ? left : -1;

        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (target < nums[mid]) right = mid;
            else if (target > nums[mid]) left = mid + 1;
        }
        res[1] = (left >= 1 && nums[left - 1] == target) ? left - 1 : -1;
        return res;
    }

    
}
// @lc code=end

