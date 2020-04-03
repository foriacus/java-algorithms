/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
    public String toLowerCase(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                s[i] = (char)(s[i] - 'A' + 'a');
            }
        }
        return new String(s);
    }
}
// @lc code=end

