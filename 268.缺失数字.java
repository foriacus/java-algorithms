/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = n * (n + 1) / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return x - sum;
    }

    // 方法二 XOR
}
// @lc code=end

