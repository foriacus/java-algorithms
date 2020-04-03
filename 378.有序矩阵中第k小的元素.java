/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            
        }
    }
}
// @lc code=end

