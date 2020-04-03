/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    /**
     * 还有一种一行完成碉堡了的方法，就是我们其实可以在A之后再加上一个A，
     * 这样如果新的字符串(A+A)中包含B的话，说明A一定能通过偏移得到B。
     * 就比如题目中的例子，A="abcde", B="bcdea"，那么A+A="abcdeabcde"，里面是包括B的，所以返回true即可
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString1(String A, String B) {
        return A.length() == B.length() && (A + A).indexOf(B) > -1;
    }

    /** 
     * 这道题给了我们两个字符串A和B，定义了一种偏移操作，以某一个位置将字符串A分为两截，并将两段调换位置，
     * 如果此时跟字符串B相等了，就说明字符串A可以通过偏移得到B。现在就是让我们判断是否存在这种偏移，
     * 那么最简单最暴力的方法就是遍历所有能将A分为两截的位置，然后用取子串的方法将A断开，交换顺序，再去跟B比较，
     * 如果相等，返回true即可，遍历结束后，返回false，参见代码如下：
    */
    public boolean rotateString2(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if ((A.substring(i, n) + A.substring(0, i)).indexOf(B) > -1) return true;
        }
        return false;
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if ((A.substring(i, n) + A.substring(0, i)).equals(B)) return true;
        }
        return false;
    }
}
// @lc code=end

