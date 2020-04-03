import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) {
                break;
            }
            set.add(n);
        }
        return n == 1;
    }
}
// @lc code=end

