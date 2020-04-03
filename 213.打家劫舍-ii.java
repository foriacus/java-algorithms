/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    // 把第一家和最后一家分别去掉，各算一遍能抢的最大值，然后比较两个值取其中较大的一个即为所求。
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }

    private int rob(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return nums[left];
        }
        int[] dp = new int[right];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i < right; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[right - 1];
    }
}
// @lc code=end

