/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare1(int num) {
        // 折半法
        if (num == 1) return true;
        long x = num / 2, t = x * x;
        while (t > num) {
            x /= 2;
            t = x * x;
        }
        for (long i = x; i <= 2 * x; ++i) {
            if (i * i == num) return true;
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    // 二分法
    public boolean isPerfectSquare3(int num) {
        long left = 0, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2, t = mid * mid;
            if (t == num) return true;
            if (t < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 完全平方数是一系列奇数之和，例如：

        1 = 1
        4 = 1 + 3
        9 = 1 + 3 + 5
        16 = 1 + 3 + 5 + 7
        25 = 1 + 3 + 5 + 7 + 9
        36 = 1 + 3 + 5 + 7 + 9 + 11
        ....
        1+3+...+(2n-1) = (2n-1 + 1)n/2 = n*n
     */

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

}
// @lc code=end

