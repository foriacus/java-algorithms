/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 单一元素的索引必定是偶数
        // 二叉查找
        // [01][23[45]
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int n = m % 2 == 0 ? m + 1 : m - 1;
            if (nums[m] == nums[n]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
// @lc code=end

