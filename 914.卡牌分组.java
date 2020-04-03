import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
class Solution {
    // HashTable + Brute Force
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int i = 2; i <= deck.length; i++) {
            if (deck.length % i != 0) continue;
            boolean ok = true;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if (entry.getValue() % i != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }
}
// @lc code=end

