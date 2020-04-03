import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != -1 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
            
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums[i] - 1] == nums[i] && nums[i] != i + 1) { 
                res.add(nums[i]);
                nums[i] = -1;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
// @lc code=end

