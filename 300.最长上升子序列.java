import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     // 方法一 DP
    //     if (nums == null || nums.length != 0) {
    //         return 0;
    //     }
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 1);
    //     int res = 0;
    //     for (int i = 1; i < n; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (nums[i] > nums[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         res = Math.max(res, dp[i]);
    //     }
    //     return res;
    // }

    public int lengthOfLIS(int[] nums) {
        // 方法二 binary search
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> ends = new ArrayList<>();
        ends.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            if (a < ends.get(0)) {
                ends.set(0, a);
            } else if (a > ends.get(ends.size() - 1)) {
                ends.add(a);
            } else {
                int left = 0;
                int right = ends.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (ends.get(mid) < a) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                ends.set(right, a);
            }
        }
        return ends.size();
    }
}
// @lc code=end

