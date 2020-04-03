/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    // 方法一：binary search
    public int findDuplicate(int[] nums) {
        // smallest num -> len( num <= m ) > m
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // 方法二 快慢指针法
    // public int findDuplicate(int[] nums) {
        
    // }
}
// @lc code=end

