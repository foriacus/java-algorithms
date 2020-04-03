import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // 检查第i行，在横坐标位置
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                // 检查第i列，在纵坐标位置
                if (board[j][i] != '.' && !column.add(board[j][i])) {
                    return false;
                }
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

