import java.util.List;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode m = new TreeNode(root.val);
            m.left = mirrorTree(root.right);
            m.right = mirrorTree(root.left);
            return m;
        }
        return null;
    }
    
    public boolean same(TreeNode a,  TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null && b != null || a != null && b == null) return false;
        return a.val == b.val && same(a.left, b.left) && same(a.right, b.right);
    }
    
    

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode mirror = mirrorTree(root);
        return same(root, mirror);
    } */

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null && b != null || a != null && b == null) return false;
        return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
}
// @lc code=end

