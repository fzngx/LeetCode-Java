/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        q.offer(root);
        level.offer(0);

        int preLevel = 0;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int curLevel = level.poll();
            
            if (curLevel != preLevel) {
                res.add(new ArrayList<>(list));
                preLevel = curLevel;
                list.clear();
            }
            list.add(node.val);

            if (node.left != null) {
                q.offer(node.left);
                level.offer(curLevel + 1);
            }
            if (node.right != null) {
                q.offer(node.right);
                level.offer(curLevel + 1);
            }
        }
        res.add(list);
        return res;
    }
}
// @lc code=end

