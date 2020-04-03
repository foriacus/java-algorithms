import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, candidates, target, cur, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> cur, int start) {
        if (0 == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) {
                break;
            }
            cur.add(num);
            helper(res, candidates, target - num, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

