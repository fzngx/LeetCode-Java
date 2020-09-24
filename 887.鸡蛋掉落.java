/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
    public int superEggDrop(int K, int N) {
        if (N == 0) return 0;
        if (K == 1) return N;
            
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(superEggDrop(K-1, i - 1),
                    superEggDrop(K, N - i)) + 1);
        }
        return res;
    }
}
// @lc code=end

