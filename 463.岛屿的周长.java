/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                cnt += 4;
                if (i > 0 && grid[i-1][j] == 1) cnt -= 2;
                if (j > 0 && grid[i][j-1] == 1) cnt -= 2;
            }
        }
        return cnt;
    }
}
// @lc code=end

