/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int n = intervals.length;
        int res = 0;

        int i = 0, j = 1;
        while ( j < n) {
            if (intervals[j][0] < intervals[i][1]) res++;
            else i = j;
            j++;
        }
        return res;
    }
}
// @lc code=end

