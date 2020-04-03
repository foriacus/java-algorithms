import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 排序法
        /**
        Arrays.sort(nums);
        return nums[nums.length - k];
         */
        // 优先队列 构造小顶堆
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                // 获取并删除队首元素
                queue.poll();
            }
        }
        // 都是获取但不删除队首元素，也就是队列中权值最小的那个元素
        return queue.peek();
    }
}
// @lc code=end

