/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int res = 0; 
        int n = A.length;
        // 其中dp[i]表示，到i位置为止的算数切片的个数
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
// @lc code=end

