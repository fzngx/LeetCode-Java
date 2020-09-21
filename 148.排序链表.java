/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    // SelectSort, time complexity: O(n^2), space Complexity: O(1)
    public ListNode selectSort(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode sorted = sentinel;

        while (sorted.next != null) {
            ListNode preMin = sorted;

            for (ListNode pre = sorted; pre.next != null; pre = pre.next) {
                if (pre.next.val < preMin.next.val) {
                    preMin = pre;
                }
            }
            if (preMin.next != null) {
                ListNode min = preMin.next;
                preMin.next = min.next;
                min.next = sorted.next;
                sorted.next = min;
                sorted = min;
            }
        }
        return sentinel.next;
    }

    // InsertionSort, time complexity: O(n^2), space complexity: O(1)
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0, head);


        for (ListNode sorted = sentinel.next; sorted.next != null; ) {
            ListNode p = sorted.next;
            sorted.next = sorted.next.next;

            ListNode ptr;
            for (ptr = sentinel; ptr != sorted; ptr = ptr.next) {
                if (ptr.next.val > p.val) {
                    p.next = ptr.next;
                    ptr.next = p;
                    break;
                }
            }
            if (ptr == sorted) {
                p.next = ptr.next;
                ptr.next = p;
                sorted = p;
            }
        }
        return sentinel.next;
    }
}
// @lc code=end

