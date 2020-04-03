import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().split("[^a-z]");
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));

        for (String word : arr) {
            if ("".equals(word)) {
                continue;
            }
            if (!set.contains(word)) {
                map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            }
        }
        int max = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
// @lc code=end

