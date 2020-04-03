import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        HashSet<Character> set = new HashSet<>();
        for (char cc : A.toCharArray()) {
            set.add(cc);
        }
        if (A.equals(B) && set.size() < A.length()) return true;

        List<Integer> diff = new ArrayList<>();
        for (int i = 0 ; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            }
        }
        return (diff.size() == 2) && (A.charAt(diff.get(0)) == B.charAt(diff.get(1)))
            && (A.charAt(diff.get(1)) == B.charAt(diff.get(0)));
    }
}
// @lc code=end

