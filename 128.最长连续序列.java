/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int  x: nums) {
            set.add(x);
        }

        int ans = 0;
        for (int x: nums) {
            if (!set.contains(x - 1)) {
                int count = 0;
                int t = x;
                while (set.contains(t)) {
                    t++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
// @lc code=end

