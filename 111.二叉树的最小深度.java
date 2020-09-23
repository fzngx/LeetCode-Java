/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode tree) {
        if (tree == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        int n = 1;

        q.offer(tree);
        while (!q.isEmpty()) {
            depth++;
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            n = q.size();
        }
        return depth;
    }
}
// @lc code=end

