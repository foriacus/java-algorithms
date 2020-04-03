/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; i++) {
            inc &= (A[i - 1] <= A[i]);
            dec &= (A[i - 1] >= A[i]);
            if (!inc && !dec) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

