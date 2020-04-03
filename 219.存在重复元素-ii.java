import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && (i - map.get(num) <= k)) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
// @lc code=end

