/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 1;
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        int[] tops = new int[nums.length];
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tops[mid] == nums[i]) {
                    right = mid;
                } else if (nums[i] < tops[mid]) {
                    right = mid;
                } else if (nums[i] > tops[mid]) {
                    left = mid + 1;
                }
            }
            if (piles == left)  piles++;
            tops[left] = nums[i];
        }
        return piles;   
    }
}
// @lc code=end

