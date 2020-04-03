/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        // hash-table
        int[] bucket = new int[26];
        int ans = 0;
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            bucket[c - 'a']++;
        }
        for (String word : words) {
            int[] count = new int[26];
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                count[c - 'a']++;
                if (count[c - 'a'] > bucket[c - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans += word.length();
            }
        }
        return ans;
    }
}
// @lc code=end

