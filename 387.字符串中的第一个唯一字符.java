import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        // 先拿到map。字符和次数的映射
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            } else {
                map.put(cur, -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if (map.get(c) > -1 && map.get(c) < min) {
                min = map.get(c);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
// @lc code=end

