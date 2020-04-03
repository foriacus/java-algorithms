import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // PriorityQueue默认最小堆
        /**
         * 改成最大堆
         * public int compare(Integer o1, Integer o2) {
         *   return o2-o1;
         * }
         */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
        (b[0]*b[0]+ b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.remove();
            }
        }
        int[][] result = new int[K][2];
        while (K-- > 0) {
            result[K] = maxHeap.remove();
        }
        return result;
    }
}
// @lc code=end

