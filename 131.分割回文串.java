import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(s, res, cur, 0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> cur, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                cur.add(s.substring(start, i+1));
                dfs(s, res, cur, i+1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s , int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

