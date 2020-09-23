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
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == (int)need.get(c)) valid++;
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    len = right -left;
                    start = left;
                }

                char ch = s.charAt(left);
                left++;
                if (need.containsKey(ch) ) {
                    if ((int)window.get(ch) == need.get(ch)) valid--;
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        return len  == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


}
// @lc code=end

