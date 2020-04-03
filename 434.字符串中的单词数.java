/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') continue;
            ++res;
            while (i < n && s.charAt(i) != ' ') {
                ++i;
            }
        }
        return res;
    }
}
// @lc code=end

