import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        helper(candidates, target, cur, 0, res);
        return res;
    }

    private void helper(int[] candidates, int target, List<Integer> cur, int start, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) break;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            cur.add(num);
            helper(candidates, target - num, cur, i + 1, res);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

