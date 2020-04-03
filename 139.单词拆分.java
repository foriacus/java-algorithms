import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 方法一 dp
        Set<String> dict = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
    // 方法二 bfs

    // 方法三 recursion
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> dict = new HashSet<String>(wordDict);
    //     Map<String, Boolean> map = new HashMap<String, Boolean>();
    //     return helper(s, map, dict);
    // }

    // private boolean helper(String s, Map<String, Boolean> map, Set<String> dict) {
    //     if (map.containsKey(s)) {
    //         return map.get(s);
    //     }
    //     if (dict.contains(s)) {
    //         map.put(s, true);
    //         return true;
    //     }
    //     for (int i = 1; i < s.length(); i++) {
    //         if (dict.contains(s.substring(i)) && helper(s.substring(0, i), map, dict)) {
    //             map.put(s, true);
    //             return true;
    //         }
    //     }
    //     map.put(s, false);
    //     return false;
    // }
}
// @lc code=end

