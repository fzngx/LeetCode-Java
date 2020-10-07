/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int n = points.length;
        int res = 1;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (points[i][1] < points[j][0]) {
                i = j;
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

