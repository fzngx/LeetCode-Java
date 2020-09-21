/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>>  generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows == 0) return res;

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
// @lc code=end

