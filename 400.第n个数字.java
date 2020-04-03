/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        // [1-9]， 每个数有一位数字， 这样的数有9个
        // [10-99], 每个数有两位数字， 这样的数有99-9=90个
        //[100-999], 每个数有三位数字，这样的数有999-99=900个
        int len = 1; // 用于记录所在数字的位数
        long count = 9;
        int start = 1; // 那个数
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n-1) / len; // 找到所在的那个数
        String t = String.valueOf(start);
        return Character.getNumericValue(t.charAt((n-1)%len));
    }
}
// @lc code=end

