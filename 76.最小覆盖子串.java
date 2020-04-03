import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                  ++cnt;
                  map.put(c, map.get(c) - 1);
                }
            }
            while (cnt == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, minLen);
                }
                // 开始缩小左边界
                char charLeft = s.charAt(left);
                if (map.get(charLeft) > 0) {
                    map.put(charLeft, map.get(charLeft) + 1);
                    --cnt;
                }
                ++left;
            }
        }
        return res;
    }
}
// @lc code=end

