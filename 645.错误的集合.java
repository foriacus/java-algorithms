import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        // step1 : 先统计每个数字出现的次数
        int[] cnt = new int [nums.length];
        int[] res = new int[2];

        for (int num : nums) {
            ++cnt[num - 1];
        }
        for (int i = 0; i < cnt.length; i++) {
            if (res[0] != 0 && res[1] != 0) {
                return res;
            }
            if (cnt[i] == 2) {
                res[0] = i + 1;
            } else if (cnt[i] == 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end

