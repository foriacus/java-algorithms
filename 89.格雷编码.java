import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        // dfs traversal
        int p = Math.pow(2, n);
        List<Integer> res = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        int cur = 0;
        res.add(0);
        map.put(cur, true);

        for (int i = 1; i < p; i++) {
            for (int k = 0; k < n; k++) {
                int next = cur^(1<<k);
                if (map.get(next)) continue;
                cur = next;
                map.put(cur, true);
                res.add(cur);
                break;
            }
        }
        return res;
    }
}
// @lc code=end

