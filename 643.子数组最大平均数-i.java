/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sumk = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            sumk += nums[i];
        }
        max = sumk;
        for (int i = k; i < nums.length; i++) {
            sumk += nums[i] - nums[i-k];
            max = Math.max(max, sumk);
        }
        return max * 1.0 / k;
    }
}
// @lc code=end

