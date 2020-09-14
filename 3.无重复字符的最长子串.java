import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // Time Complexity: O(N^2)
    /*
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            set.clear();
  

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    if (++len > ans) {
                        ans = len;
                    }
                    set.add(c);
                }
            }
        }
        return ans;
    }*/

    // Time Complexity: O(N)
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }
            if (j - i + 1 > ans) {
                ans = j - i + 1;
            }
            map.put(c, j);
            ++j;
        }
        return ans;
    }
}
// @lc code=end

