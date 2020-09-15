import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

    void dfs(int index, int[] candidates, int sum, int target, List<Integer> nums, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(nums));
            return;
        } 
        if (index == candidates.length || sum > target) return;
        nums.add(candidates[index]);
        dfs(index, candidates, sum + candidates[index], target, nums, ans);
        nums.remove(nums.size() - 1);
        dfs(index + 1, candidates, sum, target, nums, ans); 
    
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(0, candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
}
// @lc code=end

