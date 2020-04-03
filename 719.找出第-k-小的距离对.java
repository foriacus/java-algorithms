import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=719 lang=java
 *
 * [719] 找出第 k 小的距离对
 */

// @lc code=start
class Solution {
    // public int smallestDistancePair1(int[] nums, int k) {
    //     // 桶排序
    //     // 桶的大小
    //     // 先排序
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     int N = nums[n-1];
    //     int[] bucket = new int[N+1];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i+1; j < n; j++) {
    //             bucket[Math.abs(nums[j] - nums[i])] += 1;
    //         }
    //     }
    //     for (int i = 0; i <= N; i++) {
    //         k -= bucket[i];
    //         if (k <= 0) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n-1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                while (start < n && nums[i] - nums[start] > mid) {
                    start++;
                }
                cnt += i - start;
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
// @lc code=end

