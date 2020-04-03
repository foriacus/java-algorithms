import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // pq
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 最小堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int num : map.keySet()) {
            // Inserts the specified element into this priority queue.
            pq.offer(new int[]{map.get(num), num});
            if (pq.size() > k) {
                // Retrieves and removes the head of this queue.
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(pq.poll()[1]);
        }
        return ans;
    }

    // bucket sorting
}
// @lc code=end

