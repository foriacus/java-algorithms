/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        // Try all numbers from 2 to sqrt(n)
        // If number i is a divisor of n then n/i is another one
        // specifically, when i == n/i, only one could be added to the sum.
        if (num <= 1) return false;    
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + ((i == num / i) ? 0 : num / i );
            }
        }
        return sum == num;
    }
}
// @lc code=end

