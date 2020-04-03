import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        if (n > 0) {
            prime[1] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!prime[i]) {
                continue;
            }
            res++;
            for (int j = 2 * i; j < n; j += i) {
                prime[j] = false;
            }
        }
        return res;
    }
}
// @lc code=end

