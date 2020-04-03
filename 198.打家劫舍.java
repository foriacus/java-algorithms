/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }
        return dp[n-1];
    }
}
// @lc code=end

