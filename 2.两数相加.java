import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode p1, ListNode p2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        p.next = null;

        while (p1 != null || p2 != null) {
            int sum = carry;

            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            p.next = new ListNode(sum % 10);
            p = p.next;
            p.next = null;
            carry = sum / 10;
        }

        
        if (carry != 0) {
            p.next = new ListNode(1);
            p = p.next;
            p.next = null;
        }
        return head.next;
    }
}
// @lc code=end

