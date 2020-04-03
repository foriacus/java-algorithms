import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // map<string, freq>
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // 最小堆
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 如果频率相同，按字母出现顺序排序
                if (o1.getValue() == o2.getValue()) {
                    // desc 降序
                    return o2.getKey().compareTo(o1.getKey());
                }
                // asc 升序
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // insert
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(pq.poll().getKey());
        }
        // 要反转
        return reverseArrayList(ans);
    }

    private List<String> reverseArrayList(List<String> list) {
        // Arraylist for storing reversed elements
        List<String> revArrayList = new ArrayList<>(); 
        for (int i = list.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revArrayList.add(list.get(i));
        } 
        // Return the reversed arraylist
        return revArrayList; 
    }
}
// @lc code=end

