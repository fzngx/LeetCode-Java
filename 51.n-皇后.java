/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] cdiag;
    public static  void dfs(List<List<String>> res, List<String> list, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!cols[j] && !diag[list.size() + j] && !cdiag[j - list.size()  + n]) {
                int i = list.size();
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[j] = 'Q';

                list.add(new String(chars));
                cols[j] = diag[i + j] = true;
                cdiag[j - i + n] = true;
                dfs(res, list, n);
                cols[j] = diag[i + j] = cdiag[j - i + n] = false;
                list.remove(list.size()-1);
            }
        }

    }
    public static List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag = new boolean[2 * n + 1];
        cdiag = new boolean[2 * n + 1];

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();


        dfs(res, list, n);
        return res;
    }

}
// @lc code=end

