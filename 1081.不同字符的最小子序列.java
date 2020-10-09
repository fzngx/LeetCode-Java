/*
 * @lc app=leetcode.cn id=1081 lang=java
 *
 * [1081] 不同字符的最小子序列
 */

// @lc code=start
class Solution {
    public static String smallestSubsequence(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];

        for (char c: s.toCharArray()) {
            count[c]++;
        }

        for (char c: s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()] > 0) {
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


}
// @lc code=end

