/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    static int ans = Integer.MAX_VALUE;

    public static int jump(int[] nums) {
        int ans = 0;
        int cur = 0;
        int far = 0;
        while (far < nums.length - 1) {
            int nextfar = Integer.MIN_VALUE;
            for (int i = cur; i <= far; i++) {
                nextfar = Math.max(nextfar, i + nums[i]);
            }
            ans++;
            cur = far + 1;
            far = nextfar;
        }
        return ans;
    }
}
// @lc code=end

