import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private void dfs(int len, int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (len == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        } 
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                list.add(nums[i]);
                used[i] = true;
                dfs(len + 1, nums, used, list, res);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, used, new ArrayList<>(), res);
        return res;
    }
}
// @lc code=end

