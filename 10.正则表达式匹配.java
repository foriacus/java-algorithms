/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    // 暴力法
    // aabc a*c
    // public boolean isMatch(String s, String p) {
    //     if (s.equals(p)) return true;

    //     boolean isFirstMatch = false;
    //     if (!s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
    //         isFirstMatch = true;
    //     }

    //     if (p.length() >= 2 && p.charAt(1) == '*') {
    //         // 看 s[i]!=p[j] s[i, ...n] 和 p[j+2，...m] 
    //         // 或者是 s[i] = p[j] s[i+1, ...n] 和 p[j, ...m]
    //         return isMatch(s, p.substring(2))
    //           || (isFirstMatch && isMatch(s.substring(1), p));
    //     }

    //     return isFirstMatch && isMatch(s.substring(1), p.substring(1));
    // }

    // DP
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) return true;

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        // dp[i][i] 表示 s[0, i-1] 是否 和p[0, j-1]匹配
        boolean[][] dp = new boolean[sArr.length + 1][pArr.length + 1];
        dp[0][0] = true;

        /**
         * 确保空串和 p 的一部分是匹配，比如 s = ""，p = "a*b"，那么这里 dp[0][2] = true，
         * 也就是 s[0,0]和p[0,2] 是匹配的，注意和之前不一样的是这里的 0 代表空串
         */
        for (int i = 1; i <= pArr.length; i++) {
            dp[0][i] = pArr[i - 1] == '*' ? dp[0][i - 2] : false;
        }

        for (int i = 1; i <= sArr.length; ++i) {
            for (int j = 1; j <= pArr.length; ++j) {
                if (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '.') {
                    // 看 s[0,...i-1] 和 p[0,...j-1]
                    dp[i][j] = dp[i - 1][j - 1];
                }
    
                if (pArr[j - 1] == '*') {
                    // 看 s[0,...i] 和 p[0,...j-2]
                    dp[i][j] |= dp[i][j - 2];
    
                    if (pArr[j - 2] == sArr[i - 1] || pArr[j - 2] == '.') {
                        // 看 s[0,...i-1] 和 p[0,...j]
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
    
        return dp[sArr.length][pArr.length];
    }
}
// @lc code=end

