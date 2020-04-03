/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        // dp
        // f[i][j] 表示从i到j有几多个回文子串, 我们要求的解就是f[0][s.length()]
        // f[0][0] = true/false
        // f[0][1] = true
        // f[i][i] = true
        // 状态转移方程 f[i]f[j] = f[i]f[j-1] + 1
        int n = s.length();
        int res = 0;

        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if ((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i+1][j-1] == true)) {
                    dp[i][j] = true;
                }
                if (dp[i][j] == true) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
// @lc code=end

