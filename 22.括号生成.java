import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n > 0) helper(n, n, "", res);
        return res;
    }

    private void helper(int l, int r, String cur, List<String> res) {
        if (l + r == 0) {
            res.add(cur);
            return;
        }
        if (l > r) return;
        if (l > 0) {
            helper(l - 1, r, cur + "(", res);
        }
        if (r > 0) {
            helper(l, r - 1, cur + ")", res);
        }
    }
    /**
     * Time complexity: O(2^n)
     * Space complexity: O(k + n)
     */
}
// @lc code=end

