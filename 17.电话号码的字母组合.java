import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public void dfs(int index, String digits, List<String> combs, StringBuilder sb) {
        if (index == digits.length()) {
            combs.add(sb.toString());
            return;
        } else {
            int x = digits.charAt(index) - '0';

            for (int i = 0; i < map[x].length(); i++) {
                sb.append(map[x].charAt(i));
                dfs(index+1, digits, combs, sb);
                sb.deleteCharAt(index);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return ans;
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, ans, sb);
        return ans;
    }
}
// @lc code=end

