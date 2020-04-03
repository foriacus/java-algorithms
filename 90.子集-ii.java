import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<List<Integer>>();
        cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, cur);
        return res;
    }

    private void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> cur) {
        int n = nums.length;
        res.add(new ArrayList<>(cur));
        if (cur.size() == n) {
            return;
        }
        for (int i = pos; i < n; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            dfs(nums, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

