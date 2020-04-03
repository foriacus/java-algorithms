/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int m = (int)Math.sqrt(c);
        for (int a = 0; a <= m; a++) {
            int b = (int)Math.sqrt(c - a * a);
            if (a*a + b*b == c) return true;
        }
        return false;
    }
}
// @lc code=end

