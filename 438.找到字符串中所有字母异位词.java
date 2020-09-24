/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        int[] need = new int[128];
        int[] window = new int[128];
        
        int left = 0, right = 0;
        int valid = 0, unique = 0;
        
        for (char c: p.toCharArray()) {
            if (need[c] == 0) unique++;
            need[c]++;
        }
        
        while (right < s.length()) {
            while (right - left < p.length()) {
                char c = s.charAt(right);
                if (need[c] > 0) {
                    window[c]++;
                    if (window[c] == need[c]) {
                        valid++;
                    }
                }
                right++;
            }
            if (valid == unique) ans.add(left);
            
            if (right - left > p.length() - 1) {
                char ch = s.charAt(left);
                if (need[ch] > 0) {
                    if (window[ch] == need[ch]) {
                        valid--;
                    }
                    window[ch]--;
                }
                left++;
            }
        }
        return  ans;
    }
}
// @lc code=end

