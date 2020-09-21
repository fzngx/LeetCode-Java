/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int total = 0;
        int bulls = 0;
        
        int[] map = new int[10];
        for (char c: secret.toCharArray()) {
            map[c - '0']++;
        }
        for (char c: guess.toCharArray()) {
            if (map[c - '0'] > 0) {
                map[c - '0']--;
                total++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
        }
        
        String res = "";
        res += bulls + "A" + (total - bulls) + "B";
        return res;
    }
}
// @lc code=end

