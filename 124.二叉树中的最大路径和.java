/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
 
    public int sumTree(TreeNode root) {
        if (root != null) {
            int left = Math.max(0, sumTree(root.left));
            int right = Math.max(0, sumTree(root.right));
            ans = Math.max(ans, root.val + left + right);
            return root.val + Math.max(left, right);
        }
        return 0;
    }
    public int maxPathSum(TreeNode root) {
        sumTree(root);
        return ans;
    }
}
// @lc code=end

