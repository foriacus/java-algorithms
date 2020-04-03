/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        /**
bbbab

len = 1
i 0 to 4
  j = i
  f[0][0] f[1][1] f[2][2] f[3][3] f[4][4]


len = 2

i 0 to 3
  j = i + 1
  f[0][1] f[1][2] f[2][3] f[3][4]

len = 3

i 0 to 2
  j = i + 2
  f[0][2] f[1][3] f[2][4]

len = 4
i 0 to 1
  j = i + 3
  f[0][3] f[1][4]

len = 5
i = 0 to 0
  j = i + 4
  f[0][4]
        */
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
// @lc code=end

