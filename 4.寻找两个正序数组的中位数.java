/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    /* Time Complexity: O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums[index++] = nums1[i++];
            }
            else {
                nums[index++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            nums[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[index++] = nums2[j++];
        }

        if (index % 2 == 0) {
            return (double)(nums[index / 2] + nums[(index - 1) / 2]) / 2;
        } else {
            return nums[index / 2];
        }
    } */
    public double findKthSmallest(int[] nums1, int b1, int[] nums2, int b2, int k) {
        if (b1 == nums1.length) {
            return nums2[b2 + k - 1];
        } else if (b2 == nums2.length) {
            return nums1[b1 + k - 1];
        } else if (k == 1) {
            return nums1[b1] < nums2[b2] ? nums1[b1] : nums2[b2];
        }  else {
            int nSub = k / 2;
            if (nums1.length - b1 < k / 2) {
                nSub = nums1.length - b1;
            }
            if (nums2.length - b2 < k / 2) {
                nSub = nums2.length - b2;
            }
            if (nums1[b1 + nSub - 1] < nums2[b2 + nSub - 1]) {
                return findKthSmallest(nums1, b1 + nSub, nums2, b2 , k - nSub);
            } else {
                return findKthSmallest(nums1, b1, nums2, b2 + nSub, k - nSub);
            }
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        boolean odd = total % 2 == 1;
        if (odd) {
            return findKthSmallest(nums1, 0, nums2, 0, (total + 1) / 2);
        } else {
            return (findKthSmallest(nums1, 0, nums2, 0,  total / 2) + 
            findKthSmallest(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
        }
        
    }
}
// @lc code=end

