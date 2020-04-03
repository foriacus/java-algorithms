import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // sliding window + TreeSet
        // TreeSet数据结构（Java）使用红黑树实现，是平衡二叉树的一种。
        if (nums == null || nums.length == 0 || k < 1) return false;
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (set.floor(num) != null && num <= t + set.floor(num)
              || set.ceiling(num) != null && set.ceiling(num) <= t + num) {
                  return true;
              }
            set.add(num);
            if (i >= k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    // TODO bucket sort
}
// @lc code=end

