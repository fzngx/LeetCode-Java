/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    

    //  TreeNode pre = null;
    long pre = Long.MIN_VALUE;
    public  boolean isValidBST(TreeNode p) {
        if (p != null) {
            if (!isValidBST(p.left))  return false;
        //    if (pre != null && p.val <= pre.val) return false;
        //    pre = p;
        
            if (p.val <= pre) return false;
            pre = p.val;
            if (!isValidBST(p.right)) return false;
           
        }
        return true;
    } 


}
// @lc code=end

