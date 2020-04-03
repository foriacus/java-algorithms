/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    // 快排
    /**
     * 快排的精髓在于选一个 pivot，然后将所有小于 pivot 的数字都放在左边，大于 pivot 的数字都放在右边，等于的话放哪边都行。
     * 但是此时左右两边的数组各自都不一定是有序的，需要再各自调用相同的递归，直到细分到只有1个数字的时候，再返回的时候就都是有序的了
     */
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = nums[start], i = start + 1, j = end;
        while (i <= j) {
            
        }
    }

    // 计数排序


    // 归并排序
}
// @lc code=end

