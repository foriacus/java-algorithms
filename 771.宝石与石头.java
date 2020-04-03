import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end

