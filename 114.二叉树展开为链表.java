/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                flatten(root.left);
                TreeNode rightestL = root.left;
                while (rightestL.right != null) rightestL = rightestL.right;
                rightestL.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            flatten(root.right);
        }
    }
}
// @lc code=end

