/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                ++a;
                if (a > 1) return false;
            }
            if (c == 'L') {
                ++l;
                if (l > 2) return false;
            } else {
                l = 0;
            }
        }
        return true;
    }
}
// @lc code=end

