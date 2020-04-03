/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays1(int[] nums, int S) {
        // dp



    }


    private int ans;
    // dfs
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (final int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(S)) return 0;
        ans = 0;
        dfs(nums, 0, S);
        return ans;
    }

    private void dfs(int[] nums, int d, int S) {
        if (d == nums.length) {
            if (S == 0) ++ans;
            return;
        }
    }
}
// @lc code=end

