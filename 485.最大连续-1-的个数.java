/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
                res = Math.max(cnt, res);
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}
// @lc code=end

