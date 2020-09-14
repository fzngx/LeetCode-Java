/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            if (left == right) {
                if (nums[left] > target) return left;
                else if (nums[left] < target) return left +1;
            }
            
            else if (target < nums[mid]) right = mid - 1; 
            else left = mid +  1;
        }
        return left;
    }
}
// @lc code=end

