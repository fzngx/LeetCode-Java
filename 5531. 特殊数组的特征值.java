class Solution {
    public static int specialArray(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (i == 0 || nums[i - 1] != nums[i]) {
                    if (n - i <= nums[i] && (i == 0 || (nums[i - 1] < n - i)))
                        return n - i;
                }
            }
            return -1;
        }
}