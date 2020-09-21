/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
public class LRUCache {
    class ListNode {
        public int key, val;
        public ListNode next, prev;
        public ListNode() {}
        public ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    class List {
        ListNode head;
        int size;

        List() {
            head = new ListNode();
            head.prev = head;
            head.next = head;
            size = 0;
        }
        public void addFirst(ListNode p) {
            keyToNode.put(p.key, p);
            p.next = head.next;
            p.prev = head;
            head.next.prev = p;
            head.next = p;
            size++;
        }

        public void remove(ListNode p) {
            keyToNode.remove(p.key);
            p.prev.next = p.next;
            p.next.prev = p.prev;
            size--;
        }

        public ListNode removeLast() {
            keyToNode.remove(head.prev.key);
            ListNode p = head.prev;
            head.prev = head.prev.prev;
            head.prev.next = head;
            size--;
            return p;
        }
    }

    Map<Integer, ListNode> keyToNode;
    List data;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        data = new List();
    }

    public void put(int key, int value) {
        ListNode p;
        if (keyToNode.containsKey(key)) {
            p = keyToNode.get(key);
            p.val = value;
            data.remove(p);
        } else {
            if (data.size == capacity) {
                data.removeLast();
            }
            p = new ListNode(key, value);
            keyToNode.put(key, p);

        }
        data.addFirst(p);
    }

    public int get(int key) {
        if (keyToNode.containsKey(key)) {
            ListNode p = keyToNode.get(key);
            data.remove(p);
            data.addFirst(p);
            return p.val;
        }
        return -1;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

