import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // HashMap + HashSet
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer count : map.values()) {
            if (set.contains(count)) {
                return false;
            }
            set.add(count);
        }
        return true;
    }
}
// @lc code=end

