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
    /*
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
    } */
    
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0, right = 0;
        int[] window = new int[128];

        while (right < s.length()) {
            while (right < s.length()) {
                char c1 = s.charAt(right);
                window[c1]++;
                right++;
                if (window[c1] == 2) break;
            }
            if (right == s.length() && window[s.charAt(s.length() - 1)] == 1) {
                maxLen = Math.max(right - left, maxLen);
            } else {
                maxLen = Math.max(right - left -1 , maxLen);
            }
            if (right == s.length()) break;

            while (left < right) {
                int c2 = s.charAt(left);
                window[c2]--;
                left++;
                if (window[c2] == 1) break;
            }
        }
        return maxLen;
    }
}
// @lc code=end

