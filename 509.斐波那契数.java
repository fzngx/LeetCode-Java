/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (N == 0 || N == 1) return N;
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int t = a + b;
            a = b; 
            b = t;
        }
        return b;
    }
}
// @lc code=end

