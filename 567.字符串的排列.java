/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    // sliding window
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) return false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < l1; i++) {
            c1[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < l2; i++) {
            if (i >= l1) {
                c2[s2.charAt(i - l1) - 'a'] -= 1;
            }
            c2[s2.charAt(i) - 'a'] += 1;
            if (isSame(c1, c2)) return true;
        }
        return false;
    }

    private boolean isSame(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

