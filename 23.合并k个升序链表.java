import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    /* runtime: 9.13%
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode sentinel = new ListNode(0);
        ListNode p = sentinel;

        boolean stop = false;
        while (true) {

            int min = Integer.MAX_VALUE;
            int minPos = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    minPos = i;
                }
            }
            if (minPos == -1) break;
            p.next = new ListNode(min);
            p = p.next;
            p.next = null;
            lists[minPos] = lists[minPos].next;
        }
        return sentinel.next;
    } */
    
    // Runtime: 58.5% O(nlog(k))
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)  return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });

        ListNode sentinel = new ListNode(0);
        ListNode p = sentinel;
        for (ListNode node: lists) {
            if (node != null) pq.offer(node);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) pq.offer(node.next);
        }
        p.next = null;
        return sentinel.next;
    } */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
   
}
// @lc code=end

