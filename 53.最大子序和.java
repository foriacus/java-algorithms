import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // 不能用滑动窗口，此解法也可看作是DP
        int n = nums.length;
        if (n == 0) return 0;

        int res = nums[0];
        int tmp = nums[0];

        for (int i = 1; i < n; i++) {
            if (tmp > 0) {
                tmp = tmp + nums[i];
            } else {
                tmp = nums[i];
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    // TODO 分治法
}
// @lc code=end

