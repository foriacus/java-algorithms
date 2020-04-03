/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    int h;
    int w;
    public boolean exist(char[][] board, String word) {
        if (word == null || board.length == 0) return false;
        h = board.length;
        w = board[0].length;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    // h = 3, w = 1, 
    private boolean search(char[][] board, String word, int start, int x, int y) {
        if (x < 0 || x == w || y < 0 || y == h || board[y][x] != word.charAt(start)) {
            return false;
        }
        if (start == word.length() - 1) {
            return true;
        }
        char cur = board[y][x];
        // 同一个单元格内的字母不允许被重复使用。
        board[y][x] = '.';
        boolean found = search(board, word, start+1, x+1, y)
                    || search(board, word, start+1, x-1, y)
                    || search(board, word, start+1, x, y+1)
                    || search(board, word, start+1, x, y-1);
        board[y][x] = cur;
        return found;
    }
}
// @lc code=end

