/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    // 左右双指针法
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            } else if (sum < target) {
                ++i;
            } else {
                --j;
            }
        }
        return new int[]{i+1, j+1};
    }

    // 二分法
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            int l = i + 1;
            int r = n;
            int t = target - numbers[i];
            while (l < r) {
                int m = l + (r - l) / 2;
                if (numbers[m] == t) {
                    return new int[]{i+1, m+1};
                } else if (numbers[m] < t) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return new int[]{};
    }
}
// @lc code=end

