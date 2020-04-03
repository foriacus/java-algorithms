/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    public int integerReplacement1(int n) {
        // 递归，速度慢
        if (n == 1) return 0;
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        } else {
            return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n-1));
        }
    }

    // 位运算法
    /**
     * 当n是奇数的时候，如何决定应该加1还是减1？我们可以看这个数字的二进制。奇数的二进制一定是01或11结尾。
     * 同时，发现如果把一个奇数化为4的倍数，变成1的步骤会更少（3除外）。
     * 15 -> 16 -> 8 -> 4 -> 2 -> 1
     * 15 -> 14 -> 7 -> 6 -> 3 -> 2 -> 1
     * 那么，如果结尾是01，那么应该对其-1；如果结尾是11，那么应该对其+1；
     * 如果这个数字是3，需要对其-1。直接迭代求解，速度很快。
     */
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;
        int count = 0;
        while (n > 1) {
            if (n % 2 != 0) { // n是奇数
                if ((n+1) % 4 == 0  && n != 3) {
                    n++;
                } else {
                    n--;
                }
            } else { // n是偶数
                n = n / 2;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

