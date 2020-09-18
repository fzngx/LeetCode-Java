/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) return null;
        TreeNode p = new TreeNode(preorder[preL]);
//        int k;
//        for (k = inL; k <= inR; k++) {
//            if (preorder[preL] == inorder[k]) break;
//        }
        int k = map.get(preorder[preL]);
        p.left = build(preorder, preL + 1, preL + k - inL, inorder, inL, k - 1);
        p.right = build(preorder, preL + k - inL + 1, preR, inorder, k + 1, inR);
        return p;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
// @lc code=end

