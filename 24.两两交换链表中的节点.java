/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode p = sentinel;
        
        while (p.next != null && p.next.next != null) {
            ListNode a = p.next;
            ListNode b = a.next;
            
            a.next = b.next;
            b.next = a;
            p.next = b;
            
            p = a;
        }
        return sentinel.next;
    }
}
// @lc code=end

