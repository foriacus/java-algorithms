/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // dp
        // dp[i]
        // if (nums[i] > nums[i-1]) dp[i] = dp[i-1] + 1
        // else 
        if (nums.length == 0) return 0;
        int cur = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                ++cur;
                ans = Math.max(ans, cur);
            } else {
                cur = 1;
            }
        }
        return ans;
    }
}
// @lc code=end

