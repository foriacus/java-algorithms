/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[ i - 1] + nums[i];
            }
        }
    }
    // prefix sum
    public int sumRange(int i, int j) {
        // sums[i] = nums[0] + nums[1] + ... + nums[i]
        // sumsumRange(i, j) = sums[j] - sums[i - 1]
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

