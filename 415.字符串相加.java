/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int sum2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = sum1 + sum2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

