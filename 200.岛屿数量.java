/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    // For every land, visit its neighbor land using DFS until there is no such land,
    // mark every visited node as 0.
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int res = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == '1') {
                    res++;
                    dfs(grid, x, y, m, n);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        dfs(grid, x + 1, y, m, n);
        dfs(grid, x - 1, y, m, n);
        dfs(grid, x, y + 1, m, n);
        dfs(grid, x, y - 1, m, n);
    }
}
// @lc code=end

