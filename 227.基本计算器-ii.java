/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    int i = 0;
    public int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();

        int num = 0;
        char op = '+';
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = calculate(s);
            }
            if (!isDigit(c) && c != ' ' || i == s.length() || c == ')') {
                switch (op) {
                    case '+': numStack.push(num); break;
                    case '-': numStack.push(-num); break;
                    case '*': numStack.push(numStack.pop() * num); break;
                    case '/': numStack.push(numStack.pop() / num); break;
                }
                num = 0;
                op = c;
            }
            if (c == ')') {
                break;
            }
        }

        int ans = 0;
        while (!numStack.isEmpty()) {
            ans += numStack.pop();
        }
        return ans;
    }
}
// @lc code=end

