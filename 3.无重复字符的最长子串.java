import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // two pointers + HashSet
    // 解法一
    // public int lengthOfLongestSubstring(String s) {
    //     int res = 0, left = 0, right = 0;
    //     HashSet<Character> set = new HashSet<>();
    //     while(right < s.length()) {
    //         if (!set.contains(s.charAt(right))) {
    //             set.add(s.charAt(right++));
    //             res = Math.max(res, set.size());
    //         } else {
    //             set.remove(s.charAt(left++));
    //         }
    //     }
    //     return res;
    // }

    // 解法二
    public int lengthOfLongestSubstring(String s) {
        // map记录 字符和字符出现的位置
        int res = 0;
        int left = -1;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ss = s.charAt(i);
            if (map.containsKey(ss) && map.get(ss) > left) {
                left = map.get(ss);
            }
            map.put(ss, i);
            res = Math.max(res, i - left);
        }
        return res;
    }
}
// @lc code=end

