/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] fwd = new int[n];
        int[] bwd = new int[n];

        fwd[0] = 1;
        bwd[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            fwd[i] = fwd[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            bwd[i] = bwd[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = fwd[i] * bwd[i];
        }
        return res;
    }
}
// @lc code=end

