import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix1(String[] strs) {
        // brute force
        // Time: O(n*m) (n是字符串个数，m是字符串最长长度)  Space: O(m)
        if (strs == null || strs.length == 0) return "";
        String res = new String();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.length() <= i || s.charAt(i) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
            
        }
        return res;
    }
    public String longestCommonPrefix2(String[] strs) {
        // brute force
        // Time: O(n*m) (n是字符串个数，m是字符串最长长度)  Space: O(m)
        if (strs == null || strs.length == 0) return "";
        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= j || strs[i].charAt(j) != c) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0];
    }
    // TODO
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        int i = 0, len = Math.min(strs[0].length(), strs[strs.length - 1].length());
        while (i < len && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) i++;
        return strs[0].substring(0, i);
    }
}
// @lc code=end

