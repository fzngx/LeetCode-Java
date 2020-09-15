import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    /* 
    // 1. 动态规划
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int ans = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    if (i == 1) dp[i] = 2;
                    else dp[i] = dp[i-2] + 2;
                } else {
                    if (s.charAt(i - 1) == ')' ) {
                        if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                            dp[i] = dp[i-1] + (i - dp[i-1] >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
                        }
                    }
                }
            } else {
                dp[i] = 0;
            }
            if (dp[i] > ans) ans = dp[i];
        }
        return ans;
    } */

    /*
    // 2. Stack
    public int longestValidParentheses(String s) {
        Stack<Integer> stack  = new Stack<>();
        stack.push(-1);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    if (len > ans) ans = len;
                }
            }
        }
        return ans;
    } */

    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') ++left;
            else ++right;

            if (left == right) {
                if (left + right > ans) ans = left + right;
            } 
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') ++left;
            else ++right;

            if (left == right) {
                if (left + right > ans) ans = left + right;
            } else if (left > right) {
                left = 0;
                right = 0;
            } 
        }
        return ans;
    }
}
// @lc code=end

