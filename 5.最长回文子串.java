/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int n = s.length();
        int[][] dp = new int[n][n];
        int left = 0;
        int len = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((i - j < 2) || dp[j+1][i-1] == 1) {
                        dp[j][i] = 1;
                    }
                }
                if (dp[j][i] == 1 && len < i-j+1) {
                    len = i - j + 1;
                    left = j;
                }
            }
        }
        return s.substring(left, len + left);
    }
}
// @lc code=end

