import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            // 避免重复三元组
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            // 双指针算法，有序数组找特定和的两元素
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

