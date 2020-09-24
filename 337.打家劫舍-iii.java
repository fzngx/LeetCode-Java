/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    /*
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int rob_it = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_rob_it = (root.left == null ? 0 : rob(root.left))
                + (root.right == null ? 0 : rob(root.right));
        int res = Math.max(rob_it, not_rob_it);
        map.put(root, res);
        return res;
    } */
    public int[] robHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        int rob_it = root.val + left[0] + right[0];
        int not_rob_it = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{not_rob_it, rob_it};
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
}
// @lc code=end

