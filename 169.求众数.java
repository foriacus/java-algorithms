import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // 迭代法
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int maxCount = 0;
        int res = nums[0];
        for (int i = 0 ; i < n; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            if (count > maxCount) {
                maxCount = count;
                res = nums[i];
            }
        }
        return res;
        // 投票法
    }
}
// @lc code=end

