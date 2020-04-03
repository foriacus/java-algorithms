/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int l = s.length();
        if (l == 0) return true;
        boolean[][] dp = new boolean[l][l];

        char[] ss = s.toCharArray();
        for (int i = 0; i < l; i++) {
            if (ss[i] == '*') {
                dp[i][i] = true;
            }
        }
    }
}
// @lc code=end

