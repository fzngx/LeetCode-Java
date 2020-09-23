/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        long bucketSize = (long)t + 1;
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long bucketId = nums[i] >= 0 ? nums[i] / bucketSize : (nums[i] + 1) / bucketSize - 1;
            if (map.containsKey(bucketId)) return true;


            if (map.containsKey(bucketId - 1) && (long)nums[i] - map.get(bucketId - 1) <= t) return true;
            if (map.containsKey(bucketId + 1) && map.get(bucketId + 1) - nums[i] <= t) return true;
            if (map.size() == k) {
                map.remove((long)nums[i - k] / bucketSize);
            }
            map.put(bucketId, (long)nums[i]);
        }
        return false;
    }
}
// @lc code=end

