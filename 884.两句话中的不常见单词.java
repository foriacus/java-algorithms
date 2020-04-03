import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] arr = (A + " " + B).split(" ");
        for (String str : arr) {
            if (!str.isEmpty()) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                result.add(key);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
// @lc code=end

