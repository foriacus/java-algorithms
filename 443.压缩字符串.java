/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int p = 0;
        for (int i = 1; i <= n; i++) {
            int count = 1;
            while (i < n && chars[i] == chars[i-1]) {
                ++i;
                ++count;
            }
            chars[p++] = chars[i - 1];
            // 没有压缩
            if (count == 1) continue;
            for (char c: String.valueOf(count).toCharArray()) {
                chars[p++] = c;
            }
        }
        return p;
    }
}
// @lc code=end

