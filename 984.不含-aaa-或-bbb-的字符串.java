/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        // 当A>B的时候，尽量先输出'a'，反之先输出'b'；
        // 当某一字母连续输出两个时，输出另一个字母。
        String ans = "";
        int a = 0;
        int b = 0;
        while (A > 0 || B > 0) {
            while (A > 0 && ((A >= B && a < 2) || b == 2)) {
                ans = ans + 'a';
                A--;
                a++;
                b = 0;
            }
            while (B > 0 && ((B >= A && b < 2) || a == 2)) {
                ans = ans + 'b';
                B--;
                b++;
                a = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

