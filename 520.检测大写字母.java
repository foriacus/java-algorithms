/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        int n = word.length();
        for (char c : word.toCharArray()) {
            if ('Z' - c >= 0) {
                cnt++;
            }
        }
        return ((cnt == 0 || cnt == n) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
    }
}
// @lc code=end

