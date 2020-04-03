/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = n / 2; i >= 1; --i) {
            if (n % i == 0) {
                int c = n / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < c; j++) {
                    sb.append(s.substring(0, i));
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    // TODO 方法二 DP
}
// @lc code=end

