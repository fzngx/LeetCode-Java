/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int left = 0, right = 0;
        int[] window = new int[128];
        int[] need = new int[128];
        int unique = 0, valid = 0;

        for (char c: s1.toCharArray()) {
            if (need[c] == 0) unique++;
            need[c]++;
        }

        while (right < s2.length()) {
            while (right < left + s1.length()) {
                int c1 = s2.charAt(right);
                if (need[c1] > 0) {
                    window[c1]++;
                    if (window[c1] == need[c1]) {
                        valid++;
                    }
                }
                right++;
            }
            if (valid == unique) return true;

            if (right - left > s1.length() - 1) {
                int c2 = s2.charAt(left);
                if (need[c2] > 0) {
                    if (window[c2] == need[c2]) {
                        valid--;
                    }
                    window[c2]--;
                }
                left++;
            }
        }
        return false;
    }
}
// @lc code=end

