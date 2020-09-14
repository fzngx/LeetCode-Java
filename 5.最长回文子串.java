/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start

class Solution {
    /*
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        char charArray[] = s.toCharArray();

        boolean dp[][] = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        int end = 0;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (j - i < 3) {
                    dp[i][j] = charArray[i] == charArray[j];
                } else {
                    dp[i][j] = (charArray[i] == charArray[j] && dp[i+1][j-1]);
                }

                if (j - i + 1 > maxLen && dp[i][j]) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end+1);
    } */

    public int getPalindrome(char[] chars, int a, int b) {
        int len = chars.length;
        int pos = b;
        while (a >= 0 && b <= len - 1 && chars[a] == chars[b]) {
            a--;
            b++;
        }
        return b-pos;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        char[] chars = s.toCharArray();

        int maxLen = 1;
        String ans = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            int halfLen = getPalindrome(chars, i, i);

            if (halfLen * 2 - 1 > maxLen) {
                ans = s.substring(i - halfLen + 1, i + halfLen );
                maxLen = halfLen * 2 - 1;
            }

            halfLen = getPalindrome(chars, i, i + 1);
            if (halfLen * 2  > maxLen) {
                ans = s.substring(i - halfLen +1, i + halfLen + 1);
                maxLen = halfLen * 2;
            }
        }
        return ans;
    }
}
// @lc code=end

