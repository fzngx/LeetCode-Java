import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /*
    public static int trap(int[] height) {
        if (height.length == 0) return 0;
        int ans = 0;
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        maxL[0] = height[0];
        for (int i = 1; i < maxL.length; i++) {
            if (height[i] > maxL[i-1]) maxL[i] = height[i];
            else maxL[i] = maxL[i-1];
        }
        maxR[maxR.length - 1] = height[height.length - 1];
        for (int i = maxR.length - 2; i >= 0; i--) {
            if (height[i] > maxR[i+1]) maxR[i] = height[i];
            else maxR[i] = maxR[i+1];
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = maxL[i] < maxR[i] ? maxL[i] : maxR[i];
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        
        return ans;
    } */

    public static int trap(int[] height) {
        int ans = 0;
        int maxL = 0, maxR = 0;

        for (int i = 0, j = height.length - 1; i <= j; ) {
            if (maxL < maxR) {
                if (maxL > height[i]) ans += maxL - height[i];
                else maxL = height[i];
                i++;
            } else {
                if (maxR > height[j]) ans += maxR - height[j];
                else maxR = height[j];
                j--;
            }
        }
        return ans;
    }
}
// @lc code=end

