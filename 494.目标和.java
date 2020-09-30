/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    /*
    int ans = 0;
    
    public void dfs(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if  (sum == target) ans++;
            return;
        }
        dfs(nums, index + 1, sum + nums[index], target);
        dfs(nums, index + 1, sum - nums[index], target);
    }
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return ans;
    } */
    Map<String, Integer> memo = new HashMap<>();
    public int dfs(int[] nums, int index, int sum) {
        if (index == nums.length) {
            if  (sum == 0) return 1;
            else return 0;
        }
        String key = index + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);
        int res = dfs(nums, index + 1, sum + nums[index]) +
            dfs(nums, index + 1, sum - nums[index]);
        memo.put(key, res);
        return res;
    }
    public int findTargetSumWays1(int[] nums, int S) {
        return dfs(nums, 0, -S);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (sum < S || (sum + S) % 2 == 1) return 0;
        sum = (sum + S) / 2;

        int n = nums.length;
    /*  int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        } */

        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
            //    dp[i][j] = dp[i-1][j] + (j >= nums[i-1] ? dp[i-1][j-nums[i-1]] : 0);
                dp[j] = dp[j] + (j >= nums[i-1] ? dp[j-nums[i-1]]: 0);
            }
        }
        //return dp[n][sum];
        return dp[sum];
        
    }
}
// @lc code=end

=