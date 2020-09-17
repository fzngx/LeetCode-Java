/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        int totalNeed = t.length();
        for (char c: t.toCharArray()) {
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }
        String res = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0, j = 0;  i < s.length(); ) {
            while (j < s.length() && totalNeed > 0) {
                char c = s.charAt(j);
                if (need.containsKey(c)) {
                    if (need.get(c) > 0) totalNeed--;
                    need.put(c, need.get(c) - 1);
                }
                j++;
            }

            while (i < s.length() && totalNeed == 0) {
                if (j - i < minLen) {
                    minLen = j - i;
                    res = s.substring(i, j);
                }
                char c = s.charAt(i);
                if (need.containsKey(c)) {
                    need.put(c, need.get(c) + 1);
                    if (need.get(c) > 0) totalNeed++;
                }
                i++;
            }
            if (j == s.length()) i++;
        }
        
        return res;
    }
}
// @lc code=end

