/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                if (i != 0 && s.charAt(i - 1) == ' ') {
                    res = 1;
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

