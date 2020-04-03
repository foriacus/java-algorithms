/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // O(n)
        if (nums.length == 0) return 0;
        int left = 0, right = 0, sum = 0;
        int n = nums.length;
        int res = n + 1;

        while (right < n) {
            while (sum < s && right < n) {
                sum += nums[right++];
            }

            while (sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == n + 1 ? 0 : res;
    }

    // O(nlogn) 二分查找
}
// @lc code=end

