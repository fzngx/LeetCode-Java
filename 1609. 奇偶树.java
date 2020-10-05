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
   public static boolean isEvenOddTree(TreeNode root) {
    
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();

        boolean odd = true;
        q.offer(root);
        int n  = 1;
        while (!q.isEmpty()) {
            int pre = odd ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if (odd == (cur.val % 2 == 0)) return false;
                if (odd && cur.val <= pre || !odd && cur.val >= pre) {
                    return false;
                }

                pre = cur.val;

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            n = q.size();
            odd = !odd;
        }
        return true;
    }
}