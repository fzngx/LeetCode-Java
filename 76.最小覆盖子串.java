/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int[] need = new int[128];
        int[] window = new int[128];

        int unique = 0;
        for (char c: t.toCharArray()) {
            if (need[c] == 0) unique++;
            need[c]++;
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) valid++;
            }

            while (valid == unique) {
                if (right - left < len) {
                    len = right -left;
                    start = left;
                }

                char ch = s.charAt(left);
                left++;
                if (need[ch] > 0) {
                    if (window[ch] == need[ch]) valid--;
                    window[ch]--;
                }
            }
        }
        return len  == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


}
// @lc code=end

