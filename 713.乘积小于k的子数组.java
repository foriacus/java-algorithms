/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int res = 0, prod = 1, left = 0;
        for (int i = 0; i < nums.length; ++i) {
            prod *= nums[i];
            while (prod >= k) prod /= nums[left++];
            res += i - left + 1; 
        }
        return res;
    }
}
// @lc code=end

