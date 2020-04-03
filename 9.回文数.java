/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    // public boolean isPalindrome(int x) {
    //     // 1. 方法一 converting to string
    //     // 2. 1234
    //     /**
    //      * 首先负数肯定为false
    //      * 找第一位和最后一位，然后再接着找中间的
    //      */
    //     if (x < 0) return false;
    //     int div = 1;
    //     while (x / div >= 10) {
    //         div *= 10;
    //     }
    //     while (x > 0) {
    //         int left = x / div;
    //         int right = x % 10;
    //         if (left != right) return false;
    //         x = (x % div) / 10;
    //         div /= 100;
    //     }
    //     return true;
    // }

    // 3. 方法三 1221 判断 12 和 21，怎么取21呢。
    public boolean isPalindrome(int x) {
        // 负数 或者 x末尾为0，却不等于0
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
// @lc code=end

