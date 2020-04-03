/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board[0].length == 0) return new char[0][0];

        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int col = click[1];
        int cnt = 0;
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            // 找click的相邻
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int x = row + i;
                    int y = col + j;
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    // 如果周围有雷，则统计个数
                    if (board[x][y] == 'M') {
                        cnt++;
                    }
                }
            }
            if (cnt > 0) {
                board[row][col] = (char)(cnt + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int x = row + i;
                        int y = col + j;
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                        }
                        if (board[x][y] == 'E') {
                            int[] newPos = {x, y};
                            updateBoard(board, newPos);
                        }
                    }
                }
            }
        }
        return board;
    }
}
// @lc code=end

