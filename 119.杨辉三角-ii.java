/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res  = new ArrayList<>(rowIndex + 1);
   
        long x = 1;
  
            res.add(1);
            for (int j = 1; j <= rowIndex; j++) {
                  x = x * (rowIndex - j + 1) / j;  
                  res.add((int)x);
            }
            

        return res;
    }
}
// @lc code=end

