import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<List<Integer>>();
        cur = new ArrayList<>();
        helper(nums, 0, cur, res);
        return res;
    }

    private void helper(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() >= 2) res.add(new ArrayList<>(cur));
        TreeSet<Integer> st = new TreeSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (!cur.isEmpty() && cur.get(cur.size() - 1) > nums[i] || st.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            st.add(nums[i]);
            helper(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

