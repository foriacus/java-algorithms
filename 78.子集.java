import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        cur = new ArrayList<>();
        helper(nums, 0, cur, res);
        return res;
    }

    private void helper(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int i = pos; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

