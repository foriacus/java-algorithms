/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // 如何把一维的坐标转换成二维的坐标
        int column = matrix.length;
        int row = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[column-1][row-1]) {
            return false;
        }
        int x = 0, y = row - 1;
        while (true) {
            if (target > matrix[x][y]) {
                x++;
            } else if (target < matrix[x][y]) {
                y--;
            } else {
                return true;
            }
            if (x >= column || y < 0) {
                break;
            }
        }
        return false;
    }
}
// @lc code=end

