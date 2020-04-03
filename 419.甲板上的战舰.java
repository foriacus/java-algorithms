/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 甲板上的战舰
 */

// @lc code=start
class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X'
                    && (i == 0 || board[i-1][j] == '.')
                    && (j == 0 || board[i][j-1] == '.')) {
                    ++count;
                }
            }
        }
        return count;
    }
}
// @lc code=end

