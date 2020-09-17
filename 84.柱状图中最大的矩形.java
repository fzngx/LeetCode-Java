/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    /*
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
                    area = i  * heights[pre];
                } else {
                    area = (i - stack.getFirst() - 1) * heights[pre];
                }
                res = Math.max(area, res);

            }
        }
        while (!stack.isEmpty()) {
            int pre = stack.pop();
            int area;
            if (stack.isEmpty()) {
                area = heights[pre] * heights.length;
            } else {
                area = (heights.length - stack.getFirst() - 1) * heights[pre];
            }
            res = Math.max(area, res);
        }
        return res;
    } */
    public static int largestRectangleArea(int[] heights) {
        int[] leftLess = new int[heights.length];
        int[] rightLess = new int[heights.length];

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) left = leftLess[left];
            leftLess[i] = left;
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            int right = i + 1;
            while (right <= heights.length - 1 && heights[right] >= heights[i]) right = rightLess[right];
            rightLess[i] = right;
        }
        for (int i = 0; i < heights.length; i++) {
            int area = (rightLess[i] - leftLess[i] - 1) * heights[i];
            res = Math.max(area, res);
        }
        return res;
    }
}
// @lc code=end

