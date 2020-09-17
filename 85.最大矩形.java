/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    /*
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int w = 0;
                    for (int k = i; k >= 0; k--) {
                        for (int l = j; l >= w; l--) {
                            if (matrix[k][l] == '1') {
                                int area = (i - k + 1) * (j - l + 1);
                                res = Math.max(area, res);
                            } else {
                                w = l + 1;
                                break;
                            }
                        }
                    }
                }

            }
        }
        return res;
    } */
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[i] >= heights[stack.getFirst()]) {
                stack.push(i++);
            } else {
                int pre = stack.pop();
                int area;
                if (stack.isEmpty()) {
                    area = i * heights[pre];
                } else {
                    area = (i - stack.getFirst() - 1) * heights[pre];
                }
                res = Math.max(area, res);
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int area;
            if (stack.isEmpty()) {
                area = heights.length * heights[idx];
            } else {
                area = (heights.length - stack.getFirst() - 1) * heights[idx];
            }
            res = Math.max(area, res);
        }
        return res;
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            int[] heights = new int[n];
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    for (int k = i; k >= 0; k--) {
                        if (matrix[k][j] != '1') break;
                        else heights[j]++;
                    }
                }
            }
            res = Math.max(largestRectangleArea(heights), res);
        }
        return res;
    }
}
// @lc code=end

