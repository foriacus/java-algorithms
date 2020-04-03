/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] freqs = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)]++;
        }

        int ans = 0;
        int odd = 0;

        for (int freq : freqs) {
            ans += freq % 2 == 0 ? freq : freq - 1;
            if (freq % 2 != 0) {
                odd = 1;
            }
        }
        ans += odd;
        return ans;
    }
}
// @lc code=end

