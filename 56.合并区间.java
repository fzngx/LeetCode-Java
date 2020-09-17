import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public static int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][];
        int count = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int idx = 0;
        for (int[] interval: intervals) {
            if (idx == 0 || interval[0] > res[idx-1][1]) res[idx++] = interval;
            else res[idx-1][1] = Math.max(res[idx-1][1], interval[1]);
        }
        return Arrays.copyOf(res, idx);
    }
}
// @lc code=end

