/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode first = head.next;
        ListNode second = head;
        while (first != null) {
            if (first == second)  return true;
            if (first.next != null) first = first.next;
            if (first == second) return true;
            first = first.next;
            second = second.next;
        }
        return false;
    }
}
// @lc code=end

