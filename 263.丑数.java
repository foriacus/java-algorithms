/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int num) {
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (num != 0 && num % factor == 0) {
                num /= factor;
            }
        }
        return num == 1;
    }
}
// @lc code=end

