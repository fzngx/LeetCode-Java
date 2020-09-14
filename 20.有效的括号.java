import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.empty()) return false;
                char c = stack.pop();
                switch(cur) {
                    case ')': if (c != '(') return false; break;
                    case ']': if (c != '[') return false; break;
                    case '}': if (c != '{') return false; break;
                }
            }
        }
        return stack.empty();
    }
}
// @lc code=end

