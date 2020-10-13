/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
public class MedianFinder {
    int cnt;
    PriorityQueue<Integer> bigRoot;
    PriorityQueue<Integer> smallRoot;

    public MedianFinder() {
        cnt = 0;
        smallRoot = new PriorityQueue<>();
        bigRoot = new PriorityQueue<>(100, (o1, o2) -> o2 - o1);

    }
    public void addNum(int num) {
        cnt++;
        if (cnt == 1 || num <= bigRoot.peek()) {
            bigRoot.add(num);
        } else {
            smallRoot.add(num);
        }
    }

    public double findMedian() {
        if  (cnt == 0) return 0;
        while (bigRoot.size() < (cnt + 1) / 2) {
            bigRoot.add(smallRoot.poll());
        }
        while (bigRoot.size() > (cnt + 1) / 2) {
            smallRoot.add(bigRoot.poll());
        }
        if (cnt % 2 == 0) {
            return (double)(bigRoot.peek() + smallRoot.peek()) / 2.0;
        } else {
            return bigRoot.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

