import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        List<Integer> cur = new ArrayList<>();
        helper(n, k, res, cur, 1);
        return res;
    }

    private void helper(int n, int k, List<List<Integer>> res, List<Integer> cur, int level) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = level; i <= n; i++) {
            cur.add(i);
            helper(n, k, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

