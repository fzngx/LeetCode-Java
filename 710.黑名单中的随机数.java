/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
class Solution {

    HashMap<Integer, Integer> map;
    int sz;

    public Solution(int N, int[] blacklist) {
        sz = N - blacklist.length;
        map = new HashMap<>();
        int last = N - 1;

        for (int b: blacklist) {
            map.put(b, Integer.MAX_VALUE);
        }
        for (int b: blacklist) {
            while (map.containsKey(last)) last--;

            if (b >= sz) continue;
            map.put(b, last--);
        }
    }

    public int pick() {
        int r = new Random().nextInt(sz);
        if (map.containsKey(r)) {
            return map.get(r);
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

