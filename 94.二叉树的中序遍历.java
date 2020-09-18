import java.util.HashSet;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    /*
    public static void inorderTraversal(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode p = stack.peekFirst();
            while (p.left != null && visited.contains(p.left) == false) {
                p = p.left;
                stack.push(p);
                visited.add(p);
            }
            p = stack.pop();
            list.add(p.val);
            System.out.println(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
        }
    } */
    public static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> inStack = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();

            if (!inStack.contains(p)) {
                if (p.right != null) stack.push(p.right);
                stack.push(p);
                inStack.add(p);
                if (p.left != null) stack.push(p.left);
            } else {
                list.add(p.val);
            }
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            inorderTraversal(root, list);
        }
        return list;
    }
}
// @lc code=end

