import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    /*
    public void dfs(int left, int right, int n, String s, List<String> ans) {
        if (left == n && right == n) {
            ans.add(s);
            return;
        } 
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, s + "(", ans);
        }
        if (right < n) {
            dfs(left, right + 1, n, s + ")", ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        dfs(0, 0, n, s, ans);
        return ans;
    } */
    /*
    public class Node {
        String s;
        int left;
        int right;

        public Node(String s, int left, int right) {
            this.s = s;
            this.left = left;
            this.right = right;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node("", 0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.left == n && cur.right == n) {
                ans.add(cur.s);
            } else {
                
                if (cur.left < n) {
                    q.offer(new Node(cur.s + "(", cur.left + 1, cur.right));
                }
                if (cur.right < n && cur.left > cur.right) {
                    q.offer(new Node(cur.s + ")", cur.left, cur.right + 1));
                }
            }
        }
        return ans;
    } */

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        List<List<String>> dp = new ArrayList<>();
        
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);



        for (int i = 1; i <= n; i++) {
            List<String> dpi = new ArrayList<>();
            for (int j = 0; j < i; j++) {

                List<String> ss1 = dp.get(j);
                List<String> ss2 = dp.get(i - 1 - j);
                
                for (String s1: ss1) {
                    for (String s2: ss2) {
                        String s = "(" + s1 + ")" + s2;
                        dpi.add(s);
                    }
                }
            }
            dp.add(dpi);
        }

        return dp.get(n);
    }
}
// @lc code=end

