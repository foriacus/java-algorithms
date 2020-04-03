import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=961 lang=java
 *
 * [961] 重复 N 次的元素
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int count = map.getOrDefault(A[i], 0) + 1;
            if (count > 1) return A[i];
            map.put(A[i], count);
        }
        return -1;
    }
}
// @lc code=end

