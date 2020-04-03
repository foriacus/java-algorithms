import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) return res;
        List<Integer> cur = new ArrayList<>();
        helper(k, n, 1, cur, res);
        return res;
    }

    private void helper(int k, int n, int start, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) break;
            cur.add(i);
            helper(k, n - i, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

