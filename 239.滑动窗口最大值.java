import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    // 解法一：Sliding window + TreeMap
    // 解法二：优先队列法
    // 解法三：双端队列法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        // List<Integer> res = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k) {
                map.put(nums[i-k], map.get(nums[i-k]) - 1);
                if (map.get(nums[i-k]) == 0) {
                    map.remove(nums[i-k]);
                }
            }
            if (i >= k - 1) {
                // res.add(map.lastKey());
                res[i - k + 1] = map.lastKey();
            }
        }
        // return convertIntegers(res);
        return res;
    }

    // 优先队列 - 最大堆 - 堆顶最大
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                pq.remove(nums[i - k]);
            }
            pq.offer(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = pq.peek();
            }
        }
        return res;
    }

    // public int[] maxSlidingWindow3(int[] nums, int k) {
    //     //special case
    //     if (nums == null || nums.length < k || k == 0) return new int[0];
    //     int n = nums.length;
    //     int[] res = new int[n - k + 1];
    //     Deque<Integer> deque = new LinkedList<>();
    //     for (int i = 0; i < n; i++) {
    //         //step 1: 尾部加元素，保证左边元素都比尾部大
    //     }
    // }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
// @lc code=end

