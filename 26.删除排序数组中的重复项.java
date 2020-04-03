/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        int cur = 0;
        int n = nums.length;
        while (cur < n) {
            if (nums[pre] == nums[cur]) {
                ++cur;
            } else {
                nums[++pre] = nums[cur++];
            }
            
        }
        return nums.length == 0 ? 0 : (pre + 1);
    }
}
// @lc code=end

