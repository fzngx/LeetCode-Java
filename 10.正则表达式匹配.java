/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public  boolean dp(char[] s, int i, char[] p, int j) {
        int m = s.length, n = p.length;
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            } else {
                while (j + 1 < n) {
                    if (p[j+1] != '*') return false;
                    j += 2;
                }
                return true;
            }
        }
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key); 
        }
        boolean res = false;
        if (s[i] == p[j] || p[j] == '.') {
            if (j < n - 1 && p[j + 1] == '*') {
                res =  dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res =  dp(s, i + 1, p, j  + 1);
            }
        } else {
            if (j < n - 1 && p[j + 1] == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
    public  boolean isMatch(String s, String p) {
        return dp(s.toCharArray(), 0, p.toCharArray(), 0);
    }
}
// @lc code=end

