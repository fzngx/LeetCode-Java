/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;

        for (int x: nums) {
            if (x == candidateA) {
                countA++;
                continue;
            }
            if (x == candidateB) {
                countB++;
                continue;
            }
            if (countA <= 0) {
                candidateA = x;
                countA = 1;
                continue;
            }
            if (countB <= 0) {
                candidateB = x;
                countB = 1;
                continue;
            }
            countA--;
            countB--;
            
        }

        countA = 0;
        countB = 0;
        for (int x: nums) {
            if (x == candidateA) countA++;
            else if (x == candidateB) countB++;
        }
        if (countA > nums.length / 3) res.add(candidateA);
        if (countB > nums.length / 3) res.add(candidateB);
        return res;
    }
}
// @lc code=end

