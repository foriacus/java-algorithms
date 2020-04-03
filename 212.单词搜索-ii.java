import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    int w;
    int h;
    public List<String> findWords(char[][] board, String[] words) {
        // DFS
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
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

    private boolean search(char[][] board, String word, int pos, int x, int y) {
        if (x < 0 || x == w || y < 0 || y == h || word.charAt(pos) != board[y][x]) {
            return false;
        }
        if (pos == word.length() - 1) {
            return true;
        }
        char cur = board[y][x];
        board[y][x] = '#';
        boolean found = search(board, word, pos + 1, x + 1, y)
                    || search(board, word, pos + 1, x - 1, y)
                    || search(board, word, pos + 1, x, y + 1)
                    || search(board, word, pos + 1, x, y - 1);
        board[y][x] = cur;
        return found;
    }
}
// @lc code=end

