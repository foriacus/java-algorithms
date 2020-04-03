/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // bad case
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        int x = m-1;
        int y = 0;
        while (true) {
            if (matrix[x][y] > target) {
                --x;
            } else if (matrix[x][y] < target) {
                ++y;
            } else {
                return true;
            }
            if (x < 0 || y >= n) {
                break;
            }
        }
        return false;
    }
}
// @lc code=end

