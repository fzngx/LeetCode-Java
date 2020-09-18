import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    // DFS版
    public int maxDepth(TreeNode root, int depth) {
        if (root != null) {
            if (root.left == null && root.right == null) return depth;
            return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
        }
        return depth - 1;
    }
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }
     */

    // BFS版
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        int n = 0;
        
        while (!q.isEmpty()) {
            level++;
            n = q.size();
            
            for (int i = 0; i < n; i++) {
                TreeNode p = q.poll();
                if (p.left != null)   q.offer(p.left);
                if (p.right != null)  q.offer(p.right);
            }
        }
        return level;
    }
}
// @lc code=end

