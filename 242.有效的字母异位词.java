/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++chars[s.charAt(i) - 'a'];
        }
        for (int j = 0; j < t.length(); j++) {
            if (--chars[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

