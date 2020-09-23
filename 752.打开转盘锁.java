/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public static String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (s.charAt(i) == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }
    public static String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (s.charAt(i) == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

    public static int openLock(String[] deadends, String target) {
        int ans = 0;
        Set<String> visited = new HashSet<>();
        for (String s: deadends) {
            if (s.equals("0000")) return -1;
            visited.add(s);
        }

        Queue<String> q = new LinkedList<>();
        int count = 1;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            for (int i = 0; i < count; i++) {
                String cur = q.poll();
                if (cur.equals(target)) return ans;

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            ans++;
            count = q.size();
        }
        return -1;
    }
}
// @lc code=end

