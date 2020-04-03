/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        // sliding window
        // maintain a window that has at most K zeros.
        int l = 0;
        int zeros = 0;
        int ans = 0;
        for (int r = 0; r < A.length; r++) {
            if (A[r] == 0) ++zeros;
            while (zeros > K) {
                if (A[l++] == 0) --zeros;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
// @lc code=end

