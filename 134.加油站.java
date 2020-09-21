/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int totalLeft = 0;
        for (int i = 0; i < n; i++) {
            totalLeft += gas[i] - cost[i];
            if (totalLeft < min) {
                min = totalLeft;
                minIdx = i;
            }
        }
        return totalLeft < 0 ? -1 : (minIdx + 1) % gas.length;
    }
}
// @lc code=end

