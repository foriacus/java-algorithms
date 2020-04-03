import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        int[] used = new int[nums.length];
        helper(nums, used, res, cur);
        return res;
    }

    private void helper(int[] nums, int[] used, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i-1] && used[i - 1] == 0) continue;
            cur.add(nums[i]);
            used[i] = 1;
            helper(nums, used, res, cur);
            cur.remove(cur.size() - 1);
            used[i] = 0;
        }
    }
}
// @lc code=end

