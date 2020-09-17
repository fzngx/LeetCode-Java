/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) { 
        int cur = 0;
        for (int i = 0, j = nums.length - 1; cur <= j;) {
            if (nums[cur] == 0 ) {
                swap(nums, i, cur);
                i++;
                cur++;
            } 
            else if (nums[cur] == 2) {
                swap(nums, j, cur);
                j--;
            }
            else cur++;
        }
    }
}
// @lc code=end

